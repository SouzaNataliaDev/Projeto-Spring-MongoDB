package com.nataliasouza.workshopmongo.controller;

import java.util.List;
import java.util.stream.Collectors;


import com.nataliasouza.workshopmongo.dto.UserDTO;
import com.nataliasouza.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nataliasouza.workshopmongo.domain.User;
import com.nataliasouza.workshopmongo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    private UserRepository repository;

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(novoUser -> new UserDTO(novoUser)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping("name/{name}")
    public ResponseEntity<List<User>> getByName(@PathVariable String name) {
        return ResponseEntity.ok(service.findAllByNameContainingIgnoreCase(name));
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.save(obj);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(obj));
    }
}


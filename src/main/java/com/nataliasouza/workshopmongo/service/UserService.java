package com.nataliasouza.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import com.nataliasouza.workshopmongo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nataliasouza.workshopmongo.domain.User;
import com.nataliasouza.workshopmongo.repository.UserRepository;
import com.nataliasouza.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public Optional<User> findById(String Id) {

        Optional<User> user = repository.findById(Id);
        if (user == null) {
            throw new ObjectNotFoundException("Usuario não encontrado por id");

        }
        return user;
    }

    public Optional<User> cadastrarUsuario(User user) {

        if (repository.findByUser(user.getEmail()).isPresent())
            return Optional.empty();

        return Optional.of(repository.save(user));

    }

    public Optional<User> atualizarUser(User user) {

        if (repository.findById(user.getId()).isPresent()) {


            return Optional.ofNullable(repository.save(user));
        }
        return Optional.empty();
    }

    public List<User> findAllByNameContainingIgnoreCase(String name) {
        return repository.findAllByNameContainingIgnoreCase(name);
    }

    public User save(User obj) {
        return repository.save(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}

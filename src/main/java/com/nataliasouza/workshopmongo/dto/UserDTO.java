package com.nataliasouza.workshopmongo.dto;

import com.nataliasouza.workshopmongo.domain.User;

public class UserDTO {

    private String Id;
    private String name;
    private String email;

    public UserDTO() {

    }
public UserDTO(User obj){
        Id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
}

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

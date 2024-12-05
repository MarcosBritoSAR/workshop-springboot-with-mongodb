package com.compass.marcosbrito.semana5.dto;

import com.compass.marcosbrito.semana5.domain.User;

import java.io.Serializable;


public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    /*
    Uso esse DTO no intuito de aprenas apresentar uma projecao do autor original
     */

    private String id;
    private String name;

    public AuthorDTO() {
    }

    public AuthorDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
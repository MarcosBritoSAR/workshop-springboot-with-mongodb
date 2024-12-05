package com.compass.marcosbrito.semana5.dto;

import com.compass.marcosbrito.semana5.domain.User;

import java.io.Serializable;

//package com.compass.marcosbrito.semana5.dto;
//
//import java.io.Serializable;
//
public class UserDTO implements Serializable {
    /**
     * O que é um DTO
     * Um DTO (Data Transfer Object) é um objeto usado para transportar dados entre partes de uma aplicação,
     * geralmente para simplificar, proteger ou formatar as informações. Ele é útil para enviar apenas os dados
     * necessários em requisições, evitando expor diretamente a estrutura interna das classes principais. Por exemplo,
     * em vez de enviar todos os atributos de um objeto User, um UserDTO pode conter apenas nome e e-mail, facilitando
     * a comunicação entre sistemas.
     *
     *
     *
     * Nesse execico, o DTO será identico ao original mas em via de regra isso não é assim
     */


   private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private String email;

    public UserDTO() {
    }

    public UserDTO(User obj) {
        id = obj.getId();
        name = obj.getName();
        email = obj.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
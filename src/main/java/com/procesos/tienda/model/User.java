package com.procesos.tienda.model;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private String document;
    private String address;
    private String phone;
    private String email;
    private String password;
}

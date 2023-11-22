package com.procesos.tienda.dto;

import lombok.Getter;

@Getter
public class LoginRequest {
    private String email;
    private String password;
}

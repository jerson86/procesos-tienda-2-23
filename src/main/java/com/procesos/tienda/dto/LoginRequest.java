package com.procesos.tienda.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class LoginRequest {
    @NotNull(message = "email is required")
    @Email(message = "email not valid")
    private String email;
    @NotNull(message = "password is required")
    @Size(min = 8, message = "password min 8 characters")
    private String password;
}

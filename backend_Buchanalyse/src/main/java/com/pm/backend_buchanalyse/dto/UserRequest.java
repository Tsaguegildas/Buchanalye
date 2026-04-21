package com.pm.backend_buchanalyse.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UserRequest {
    @NotBlank(message = "Email is requered")
    @Email(message = "invalid email formst")
    private String email;
    @NotBlank(message = "Password is requered")
    private String password;
    @NotBlank(message = "firstName is requered")
    private String firstName;
    @NotBlank(message = "lastName is requered")
    private String lastName;
}

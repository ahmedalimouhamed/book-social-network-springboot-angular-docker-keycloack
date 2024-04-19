package com.example.book.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class AuthenticationRequest {
    @Email(message = "Email is not formatted")
    @NotEmpty(message = "email must not be empty")
    @NotBlank(message = "email must not be empty")
    private String email;

    @NotEmpty(message = "password must not be empty")
    @NotBlank(message = "password must not be empty")
    @Size(min = 8, message = "Password should be 8 characters long minimum")
    private String password;
}

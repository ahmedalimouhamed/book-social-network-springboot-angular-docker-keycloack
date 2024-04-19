package com.example.book.auth;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "firstname must not be empty")
    @NotBlank(message = "firstname must not be empty")
    private String firstname;

    @NotEmpty(message = "lastname must not be empty")
    @NotBlank(message = "lastname must not be empty")
    private String lastname;

    @Email(message = "Email is not formatted")
    @NotEmpty(message = "email must not be empty")
    @NotBlank(message = "email must not be empty")
    private String email;

    @NotEmpty(message = "password must not be empty")
    @NotBlank(message = "password must not be empty")
    @Size(min = 8, message = "Password should be 8 characters long minimum")
    private String password;
}

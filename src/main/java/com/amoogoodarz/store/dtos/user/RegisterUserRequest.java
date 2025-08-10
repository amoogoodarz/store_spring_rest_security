package com.amoogoodarz.store.dtos.user;


import com.amoogoodarz.store.validation.Lowercase;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RegisterUserRequest {
    @NotBlank(message = "name is required")
    @Size(max = 255, message = "maximum size is 255 characters")
    private String name;
    @NotBlank(message = "email is required")
    @Email(message = "Email must be valid")
    @Lowercase(message = "Email must be in lowercase")
    private String email;
    @NotBlank(message = "password is required")
    @Size(min = 4 , max = 8, message = "maximum size is 255 characters")
    private String password;
}

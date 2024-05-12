package com.ngash.javatechie.ExceptionHandling.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserRequest {
    @NotNull(message = "username shouldn't be null")
    private String name;
    @Email
    @NotNull(message = "email is a required field")
    private String email;
    @NotNull
    private String mobile;
    private String gender;
    @Min(value = 18, message = "Should not be younger than 18 years")
    @Max(value = 60, message = "Should not be older than 60 years")
    private int age;
    @NotBlank
    private String nationality;
}






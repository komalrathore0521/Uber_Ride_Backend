package com.project.uber.Uber.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Schema(description = "Payload for new user registration containing basic account details.")
public class SignupDto {

    @Schema(description = "User's email address", example = "user@example.com", required = true)
    @Email
    @NotBlank
    private String email;

    @Schema(description = "Full name of the user", example = "Komal Rathore", required = true)
    @NotBlank
    @Size(min = 2, max = 100)
    private String name;

    @Schema(description = "Password for the account (minimum 6 characters)", example = "P@ssw0rd", required = true)
    @NotBlank
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    public SignupDto() {
    }

    public SignupDto(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

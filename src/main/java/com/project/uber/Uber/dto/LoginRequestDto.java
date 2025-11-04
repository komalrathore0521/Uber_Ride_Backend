package com.project.uber.Uber.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Login request payload")
public class LoginRequestDto {

    @Schema(description = "User email", example = "user@example.com", required = true)
    @Email
    @NotBlank
    private String email;

    @Schema(description = "User password", example = "P@ssw0rd", required = true)
    @NotBlank
    private String password;

    public LoginRequestDto() {}

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

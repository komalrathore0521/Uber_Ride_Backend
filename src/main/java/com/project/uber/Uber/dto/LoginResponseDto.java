package com.project.uber.Uber.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Login response containing access token")
public class LoginResponseDto {

    @Schema(description = "JWT access token", example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...")
    private String accessToken;

    public LoginResponseDto() {}

    public LoginResponseDto(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
}

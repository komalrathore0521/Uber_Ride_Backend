package com.project.uber.Uber.dto;

import com.project.uber.Uber.entities.enums.Roles;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

@Schema(description = "User details including personal information and assigned roles.")
public class UserDto {

    @Schema(description = "Full name of the user", example = "Komal Rathore", required = true)
    @NotBlank
    private String name;

    @Schema(description = "Email address of the user", example = "komalrathore0521@gmail.com", required = true)
    @Email
    @NotBlank
    private String email;

    @Schema(description = "Set of roles assigned to the user", example = "[\"ROLE_RIDER\", \"ROLE_DRIVER\"]", required = true)
    @NotNull
    private Set<Roles> roles;

    public UserDto() {
    }

    public UserDto(String name, String email, Set<Roles> roles) {
        this.name = name;
        this.email = email;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }
}

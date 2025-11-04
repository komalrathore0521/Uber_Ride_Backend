package com.project.uber.Uber.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Rider details including associated user information and overall rating")
public class RiderDto {

    @Schema(description = "Unique ID of the rider", example = "301")
    private Long id;

    @Schema(description = "User account details associated with the rider", required = true, implementation = UserDto.class)
    @NotNull
    private UserDto user;

    @Schema(description = "Average rating given to the rider by drivers (1.0 - 5.0)", example = "4.7")
    private Double rating;

    public RiderDto() {
    }

    public RiderDto(UserDto user, Double rating, Long id) {
        this.id = id;
        this.user = user;
        this.rating = rating;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
}

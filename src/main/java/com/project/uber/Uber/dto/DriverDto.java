package com.project.uber.Uber.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Represents a driver, including user details, availability status, vehicle, and rating.")
public class DriverDto {

    @Schema(description = "Unique ID of the driver", example = "201")
    private Long id;

    @Schema(description = "User information associated with the driver", required = true, implementation = UserDto.class)
    @NotNull
    private UserDto user;

    @Schema(description = "Average rating of the driver (1.0 - 5.0)", example = "4.8")
    private Double rating;

    @Schema(description = "Driver's current availability status", example = "true")
    private Boolean available;

    @Schema(description = "ID of the vehicle assigned to the driver", example = "501")
    private Long vehicleId;

    public DriverDto() {
    }

    public DriverDto(Long id, UserDto user, Double rating, Boolean available, Long vehicleId) {
        this.id = id;
        this.user = user;
        this.rating = rating;
        this.available = available;
        this.vehicleId = vehicleId;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }
}

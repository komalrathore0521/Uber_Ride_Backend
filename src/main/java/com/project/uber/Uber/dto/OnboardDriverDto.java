package com.project.uber.Uber.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Payload for onboarding a new driver with vehicle reference and current location")
public class OnboardDriverDto {

    @Schema(
            description = "Unique ID of the vehicle assigned to the driver",
            example = "102",
            required = true
    )
    @NotNull
    private Long vehicleId;

    @Schema(
            description = "Driver's current geographical location represented as a Point object",
            required = true
    )
    @NotNull
    private PointDto currentLocation;

    public OnboardDriverDto() {
    }

    public OnboardDriverDto(Long vehicleId, PointDto currentLocation) {
        this.vehicleId = vehicleId;
        this.currentLocation = currentLocation;
    }

    public Long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(Long vehicleId) {
        this.vehicleId = vehicleId;
    }

    public PointDto getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(PointDto currentLocation) {
        this.currentLocation = currentLocation;
    }
}

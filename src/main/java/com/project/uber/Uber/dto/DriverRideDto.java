package com.project.uber.Uber.dto;

import com.project.uber.Uber.entities.enums.PaymentMethod;
import com.project.uber.Uber.entities.enums.RideStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Schema(description = "Represents a ride from the driver's perspective, including locations, rider, status, and fare details.")
public class DriverRideDto {

    @Schema(description = "Unique ID of the ride", example = "701")
    private Long id;

    @Schema(description = "Pickup location coordinates and type", required = true)
    @NotNull
    private PointDto pickUpLocation;

    @Schema(description = "Drop-off location coordinates and type", required = true)
    @NotNull
    private PointDto dropOffLocation;

    @Schema(description = "Timestamp when the ride was created (ISO format)", example = "2025-11-04T10:10:00")
    private LocalDateTime createdTime;

    @Schema(description = "Details of the rider associated with this ride", implementation = RiderDto.class)
    private RiderDto rider;

    @Schema(description = "Details of the driver for this ride", implementation = DriverDto.class)
    private DriverDto driver;

    @Schema(description = "Payment method selected for the ride", example = "CASH | UPI | CARD")
    private PaymentMethod paymentMethod;

    @Schema(description = "Current ride status", example = "REQUESTED | ACCEPTED | STARTED | ENDED | CANCELLED")
    private RideStatus status;

    @Schema(description = "Total fare amount in INR", example = "250.50")
    private Double fare;

    @Schema(description = "Timestamp when the ride started (ISO format)", example = "2025-11-04T10:30:00")
    private LocalDateTime startedAt;

    @Schema(description = "Timestamp when the ride ended (ISO format)", example = "2025-11-04T11:00:00")
    private LocalDateTime endedAt;

    public DriverRideDto() {
    }

    public DriverRideDto(Long id, PointDto pickUpLocation, PointDto dropOffLocation, LocalDateTime createdTime,
                         RiderDto rider, DriverDto driver, PaymentMethod paymentMethod, RideStatus status,
                         Double fare, LocalDateTime startedAt, LocalDateTime endedAt) {
        this.id = id;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.createdTime = createdTime;
        this.rider = rider;
        this.driver = driver;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.fare = fare;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PointDto getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(PointDto pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public PointDto getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(PointDto dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }

    public RiderDto getRider() {
        return rider;
    }

    public void setRider(RiderDto rider) {
        this.rider = rider;
    }

    public DriverDto getDriver() {
        return driver;
    }

    public void setDriver(DriverDto driver) {
        this.driver = driver;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }
}

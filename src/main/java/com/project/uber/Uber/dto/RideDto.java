package com.project.uber.Uber.dto;

import com.project.uber.Uber.entities.enums.PaymentMethod;
import com.project.uber.Uber.entities.enums.RideStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Schema(description = "Detailed information about a ride, including pickup/drop-off locations, participants, status, and payment details.")
public class RideDto {

    @Schema(description = "Unique ID of the ride", example = "501")
    private Long id;

    @Schema(description = "Pickup location coordinates and type", required = true)
    @NotNull
    private PointDto pickUpLocation;

    @Schema(description = "Drop-off location coordinates and type", required = true)
    @NotNull
    private PointDto dropOffLocation;

    @Schema(description = "Timestamp when the ride was created (ISO format)", example = "2025-11-04T10:15:30")
    private LocalDateTime createdTime;

    @Schema(description = "Rider details associated with the ride", implementation = RiderDto.class)
    private RiderDto rider;

    @Schema(description = "Driver details assigned to this ride", implementation = DriverDto.class)
    private DriverDto driver;

    @Schema(description = "Payment method selected for this ride", example = "CASH | UPI | CARD")
    private PaymentMethod paymentMethod;

    @Schema(description = "Current status of the ride", example = "REQUESTED | ACCEPTED | STARTED | COMPLETED | CANCELLED")
    private RideStatus status;

    @Schema(description = "Final ride fare in INR", example = "180.50")
    private Double fare;

    @Schema(description = "One-time password used for ride verification", example = "4729")
    private String otp;

    @Schema(description = "Timestamp when the ride started (ISO format)", example = "2025-11-04T10:30:00")
    private LocalDateTime startedAt;

    @Schema(description = "Timestamp when the ride ended (ISO format)", example = "2025-11-04T10:55:00")
    private LocalDateTime endedAt;

    public RideDto() {
    }

    public RideDto(Long id, PointDto pickUpLocation, RiderDto rider, String otp, DriverDto driver,
                   PointDto dropOffLocation, LocalDateTime createdTime, PaymentMethod paymentMethod,
                   RideStatus status, Double fare, LocalDateTime startedAt, LocalDateTime endedAt) {
        this.id = id;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.createdTime = createdTime;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.fare = fare;
        this.startedAt = startedAt;
        this.endedAt = endedAt;
        this.rider = rider;
        this.driver = driver;
        this.otp = otp;
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

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
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

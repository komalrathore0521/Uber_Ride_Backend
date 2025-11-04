package com.project.uber.Uber.dto;

import com.project.uber.Uber.entities.enums.PaymentMethod;
import com.project.uber.Uber.entities.enums.RideRequestStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Schema(description = "Represents a ride request made by a rider, including pickup/drop-off locations, fare, and status.")
public class RideRequestDto {

    @Schema(description = "Unique ID of the ride request", example = "701")
    private Long id;

    @Schema(description = "Pickup location coordinates and type", required = true)
    @NotNull
    private PointDto pickUpLocation;

    @Schema(description = "Drop-off location coordinates and type", required = true)
    @NotNull
    private PointDto dropOffLocation;

    @Schema(description = "Timestamp when the ride was requested (ISO format)", example = "2025-11-04T10:10:00")
    private LocalDateTime requestTime;

    @Schema(description = "Rider details who initiated the request", implementation = RiderDto.class)
    private RiderDto rider;

    @Schema(description = "Estimated fare amount for this ride (in INR)", example = "150.0")
    private Double fare;

    @Schema(description = "Selected payment method for the ride", example = "CASH | UPI | CARD")
    private PaymentMethod paymentMethod;

    @Schema(description = "Current status of the ride request", example = "PENDING | ACCEPTED | CANCELLED | COMPLETED")
    private RideRequestStatus status;

    public RideRequestDto() {
    }

    public RideRequestDto(Long id, PointDto pickUpLocation, Double fare, PointDto dropOffLocation,
                          LocalDateTime requestTime, RiderDto rider, PaymentMethod paymentMethod,
                          RideRequestStatus status) {
        this.id = id;
        this.pickUpLocation = pickUpLocation;
        this.dropOffLocation = dropOffLocation;
        this.requestTime = requestTime;
        this.fare = fare;
        this.rider = rider;
        this.paymentMethod = paymentMethod;
        this.status = status;
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

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(LocalDateTime requestTime) {
        this.requestTime = requestTime;
    }

    public RiderDto getRider() {
        return rider;
    }

    public void setRider(RiderDto rider) {
        this.rider = rider;
    }

    public Double getFare() {
        return fare;
    }

    public void setFare(Double fare) {
        this.fare = fare;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public RideRequestStatus getStatus() {
        return status;
    }

    public void setStatus(RideRequestStatus status) {
        this.status = status;
    }
}

package com.project.uber.Uber.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Payload used by the driver to start a ride after verifying the provided OTP.")
public class RideStartDto {

    @Schema(
            description = "One-time password (OTP) provided by the rider to authorize ride start",
            example = "4729",
            required = true
    )
    @NotBlank
    private String otp;

    public RideStartDto() {
    }

    public RideStartDto(String otp) {
        this.otp = otp;
    }

    public String getOtp() {
        return otp;
    }

    public void setOtp(String otp) {
        this.otp = otp;
    }
}

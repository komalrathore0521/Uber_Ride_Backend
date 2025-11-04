package com.project.uber.Uber.controllers.driver;

import com.project.uber.Uber.dto.DriverRideDto;
import com.project.uber.Uber.dto.RatingDto;
import com.project.uber.Uber.dto.RideStartDto;
import com.project.uber.Uber.dto.RiderDto;
import com.project.uber.Uber.services.DriverService;
import com.project.uber.Uber.services.RatingManagementService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/driver")
@Secured("ROLE_DRIVER")
public class DriverPostMapping {

    private final DriverService driverService;


    public DriverPostMapping(DriverService driverService, RatingManagementService ratingManagementService) {
        this.driverService = driverService;
    }

    @PostMapping("/acceptRide/{rideRequestId}")
    public ResponseEntity<DriverRideDto> acceptRide(@PathVariable Long rideRequestId) {
        return ResponseEntity.ok(driverService.acceptRide(rideRequestId));
    }


}

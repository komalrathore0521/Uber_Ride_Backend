package com.project.uber.Uber.controllers.auth;


import com.project.uber.Uber.dto.*;
import com.project.uber.Uber.services.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/auth")
public class AuthPostMapping {

    @Value("${deploy.env}")
    private String deployment;
    private final AuthService authService;

    public AuthPostMapping(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping(path = "/signup")
    public ResponseEntity<UserDto> signup(@RequestBody SignupDto signupDto){
        UserDto user = authService.signup(signupDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }


}

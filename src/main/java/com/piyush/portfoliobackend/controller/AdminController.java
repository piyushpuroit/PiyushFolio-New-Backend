package com.piyush.portfoliobackend.controller;

import com.piyush.portfoliobackend.config.JwtTokenProvider;
import com.piyush.portfoliobackend.dto.ApiResponse;
import com.piyush.portfoliobackend.dto.LoginRequestDto;
import com.piyush.portfoliobackend.dto.LoginResponseDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin("*")
public class AdminController {

    private final String adminUsername;
    private final String adminPassword;
    private final JwtTokenProvider tokenProvider;

    public AdminController(
            JwtTokenProvider tokenProvider,
            @Value("${app.admin.username}") String adminUsername,
            @Value("${app.admin.password}") String adminPassword
    ) {
        this.tokenProvider = tokenProvider;
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<LoginResponseDto>> login(@Valid @RequestBody LoginRequestDto loginRequest) {
        if (adminUsername.equals(loginRequest.getUsername()) && adminPassword.equals(loginRequest.getPassword())) {
            String token = tokenProvider.generateToken(loginRequest.getUsername());
            LoginResponseDto response = LoginResponseDto.builder()
                    .token(token)
                    .type("Bearer")
                    .build();
            return ResponseEntity.ok(ApiResponse.success("Login successful", response));
        }

        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid username or password");
    }
}

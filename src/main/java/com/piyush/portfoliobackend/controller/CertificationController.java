package com.piyush.portfoliobackend.controller;

import com.piyush.portfoliobackend.dto.ApiResponse;
import com.piyush.portfoliobackend.dto.CertificationDto;
import com.piyush.portfoliobackend.service.CertificationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certifications")
@CrossOrigin("*")
public class CertificationController {

    private final CertificationService certificationService;

    public CertificationController(CertificationService certificationService) {
        this.certificationService = certificationService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<CertificationDto>> createCertification(@Valid @RequestBody CertificationDto certificationDto) {
        CertificationDto saved = certificationService.createCertification(certificationDto);
        return new ResponseEntity<>(ApiResponse.success("Certification created successfully", saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<CertificationDto>>> getAllCertifications() {
        List<CertificationDto> list = certificationService.getAllCertifications();
        return ResponseEntity.ok(ApiResponse.success(list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CertificationDto>> getCertificationById(@PathVariable Long id) {
        CertificationDto record = certificationService.getCertificationById(id);
        return ResponseEntity.ok(ApiResponse.success(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<CertificationDto>> updateCertification(@PathVariable Long id, @Valid @RequestBody CertificationDto certificationDto) {
        CertificationDto updated = certificationService.updateCertification(id, certificationDto);
        return ResponseEntity.ok(ApiResponse.success("Certification updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteCertification(@PathVariable Long id) {
        certificationService.deleteCertification(id);
        return ResponseEntity.ok(ApiResponse.success("Certification deleted successfully", null));
    }
}

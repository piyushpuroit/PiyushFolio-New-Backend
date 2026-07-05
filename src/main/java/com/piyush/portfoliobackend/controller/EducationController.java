package com.piyush.portfoliobackend.controller;

import com.piyush.portfoliobackend.dto.ApiResponse;
import com.piyush.portfoliobackend.dto.EducationDto;
import com.piyush.portfoliobackend.service.EducationService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/education")
@CrossOrigin("*")
public class EducationController {

    private final EducationService educationService;

    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EducationDto>> createEducation(@Valid @RequestBody EducationDto educationDto) {
        EducationDto saved = educationService.createEducation(educationDto);
        return new ResponseEntity<>(ApiResponse.success("Education record created successfully", saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<EducationDto>>> getAllEducation() {
        List<EducationDto> list = educationService.getAllEducation();
        return ResponseEntity.ok(ApiResponse.success(list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EducationDto>> getEducationById(@PathVariable Long id) {
        EducationDto record = educationService.getEducationById(id);
        return ResponseEntity.ok(ApiResponse.success(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EducationDto>> updateEducation(@PathVariable Long id, @Valid @RequestBody EducationDto educationDto) {
        EducationDto updated = educationService.updateEducation(id, educationDto);
        return ResponseEntity.ok(ApiResponse.success("Education record updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEducation(@PathVariable Long id) {
        educationService.deleteEducation(id);
        return ResponseEntity.ok(ApiResponse.success("Education record deleted successfully", null));
    }
}

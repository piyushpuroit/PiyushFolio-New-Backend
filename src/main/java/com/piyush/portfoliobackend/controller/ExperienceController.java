package com.piyush.portfoliobackend.controller;

import com.piyush.portfoliobackend.dto.ApiResponse;
import com.piyush.portfoliobackend.dto.ExperienceDto;
import com.piyush.portfoliobackend.service.ExperienceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experience")
@CrossOrigin("*")
public class ExperienceController {

    private final ExperienceService experienceService;

    public ExperienceController(ExperienceService experienceService) {
        this.experienceService = experienceService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ExperienceDto>> createExperience(@Valid @RequestBody ExperienceDto experienceDto) {
        ExperienceDto saved = experienceService.createExperience(experienceDto);
        return new ResponseEntity<>(ApiResponse.success("Experience record created successfully", saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ExperienceDto>>> getAllExperiences() {
        List<ExperienceDto> list = experienceService.getAllExperiences();
        return ResponseEntity.ok(ApiResponse.success(list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ExperienceDto>> getExperienceById(@PathVariable Long id) {
        ExperienceDto record = experienceService.getExperienceById(id);
        return ResponseEntity.ok(ApiResponse.success(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ExperienceDto>> updateExperience(@PathVariable Long id, @Valid @RequestBody ExperienceDto experienceDto) {
        ExperienceDto updated = experienceService.updateExperience(id, experienceDto);
        return ResponseEntity.ok(ApiResponse.success("Experience record updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteExperience(@PathVariable Long id) {
        experienceService.deleteExperience(id);
        return ResponseEntity.ok(ApiResponse.success("Experience record deleted successfully", null));
    }
}

package com.piyush.portfoliobackend.controller;

import com.piyush.portfoliobackend.dto.ApiResponse;
import com.piyush.portfoliobackend.dto.ResumeDto;
import com.piyush.portfoliobackend.service.ResumeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/resume")
@CrossOrigin("*")
public class ResumeController {

    private final ResumeService resumeService;

    public ResumeController(ResumeService resumeService) {
        this.resumeService = resumeService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<ResumeDto>> getResume() {
        ResumeDto resume = resumeService.getResume();
        return ResponseEntity.ok(ApiResponse.success(resume));
    }

    @PutMapping
    public ResponseEntity<ApiResponse<ResumeDto>> updateResume(@Valid @RequestBody ResumeDto resumeDto) {
        ResumeDto updated = resumeService.updateResume(resumeDto);
        return ResponseEntity.ok(ApiResponse.success("Resume updated successfully", updated));
    }
}

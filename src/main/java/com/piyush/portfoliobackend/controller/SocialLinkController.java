package com.piyush.portfoliobackend.controller;

import com.piyush.portfoliobackend.dto.ApiResponse;
import com.piyush.portfoliobackend.dto.SocialLinkDto;
import com.piyush.portfoliobackend.service.SocialLinkService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/social-links")
@CrossOrigin("*")
public class SocialLinkController {

    private final SocialLinkService socialLinkService;

    public SocialLinkController(SocialLinkService socialLinkService) {
        this.socialLinkService = socialLinkService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SocialLinkDto>> createSocialLink(@Valid @RequestBody SocialLinkDto socialLinkDto) {
        SocialLinkDto saved = socialLinkService.createSocialLink(socialLinkDto);
        return new ResponseEntity<>(ApiResponse.success("Social link created successfully", saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SocialLinkDto>>> getAllSocialLinks() {
        List<SocialLinkDto> list = socialLinkService.getAllSocialLinks();
        return ResponseEntity.ok(ApiResponse.success(list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SocialLinkDto>> getSocialLinkById(@PathVariable Long id) {
        SocialLinkDto record = socialLinkService.getSocialLinkById(id);
        return ResponseEntity.ok(ApiResponse.success(record));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SocialLinkDto>> updateSocialLink(@PathVariable Long id, @Valid @RequestBody SocialLinkDto socialLinkDto) {
        SocialLinkDto updated = socialLinkService.updateSocialLink(id, socialLinkDto);
        return ResponseEntity.ok(ApiResponse.success("Social link updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSocialLink(@PathVariable Long id) {
        socialLinkService.deleteSocialLink(id);
        return ResponseEntity.ok(ApiResponse.success("Social link deleted successfully", null));
    }
}

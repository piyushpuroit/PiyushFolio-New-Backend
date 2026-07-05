package com.piyush.portfoliobackend.controller;

import com.piyush.portfoliobackend.dto.ApiResponse;
import com.piyush.portfoliobackend.dto.SkillDto;
import com.piyush.portfoliobackend.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/skills")
@CrossOrigin("*")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<SkillDto>> createSkill(@Valid @RequestBody SkillDto skillDto) {
        SkillDto saved = skillService.createSkill(skillDto);
        return new ResponseEntity<>(ApiResponse.success("Skill created successfully", saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<SkillDto>>> getAllSkills() {
        List<SkillDto> skills = skillService.getAllSkills();
        return ResponseEntity.ok(ApiResponse.success(skills));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<SkillDto>> getSkillById(@PathVariable Long id) {
        SkillDto skill = skillService.getSkillById(id);
        return ResponseEntity.ok(ApiResponse.success(skill));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<SkillDto>> updateSkill(@PathVariable Long id, @Valid @RequestBody SkillDto skillDto) {
        SkillDto updated = skillService.updateSkill(id, skillDto);
        return ResponseEntity.ok(ApiResponse.success("Skill updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteSkill(@PathVariable Long id) {
        skillService.deleteSkill(id);
        return ResponseEntity.ok(ApiResponse.success("Skill deleted successfully", null));
    }
}

package com.piyush.portfoliobackend.controller;

import com.piyush.portfoliobackend.dto.ApiResponse;
import com.piyush.portfoliobackend.dto.ProjectDto;
import com.piyush.portfoliobackend.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
@CrossOrigin("*")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ProjectDto>> createProject(@Valid @RequestBody ProjectDto projectDto) {
        ProjectDto saved = projectService.createProject(projectDto);
        return new ResponseEntity<>(ApiResponse.success("Project created successfully", saved), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProjectDto>>> getAllProjects() {
        List<ProjectDto> projects = projectService.getAllProjects();
        return ResponseEntity.ok(ApiResponse.success(projects));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectDto>> getProjectById(@PathVariable Long id) {
        ProjectDto project = projectService.getProjectById(id);
        return ResponseEntity.ok(ApiResponse.success(project));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<ProjectDto>> updateProject(@PathVariable Long id, @Valid @RequestBody ProjectDto projectDto) {
        ProjectDto updated = projectService.updateProject(id, projectDto);
        return ResponseEntity.ok(ApiResponse.success("Project updated successfully", updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.ok(ApiResponse.success("Project deleted successfully", null));
    }
}

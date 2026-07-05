package com.piyush.portfoliobackend.service;

import com.piyush.portfoliobackend.dto.ProjectDto;
import com.piyush.portfoliobackend.entity.Project;
import com.piyush.portfoliobackend.exception.ResourceNotFoundException;
import com.piyush.portfoliobackend.mapper.ProjectMapper;
import com.piyush.portfoliobackend.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public ProjectDto createProject(ProjectDto projectDto) {
        Project project = ProjectMapper.toEntity(projectDto);
        Project saved = projectRepository.save(project);
        return ProjectMapper.toDto(saved);
    }

    public List<ProjectDto> getAllProjects() {
        return projectRepository.findAllByOrderByDisplayOrderAsc().stream()
                .map(ProjectMapper::toDto)
                .collect(Collectors.toList());
    }

    public ProjectDto getProjectById(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
        return ProjectMapper.toDto(project);
    }

    public ProjectDto updateProject(Long id, ProjectDto projectDto) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));

        project.setTitle(projectDto.getTitle());
        project.setShortDescription(projectDto.getShortDescription());
        project.setLongDescription(projectDto.getLongDescription());
        project.setTechnologies(projectDto.getTechnologies());
        project.setGithubUrl(projectDto.getGithubUrl());
        project.setLiveUrl(projectDto.getLiveUrl());
        project.setImageUrl(projectDto.getImageUrl());
        project.setFeatured(projectDto.isFeatured());
        project.setDisplayOrder(projectDto.getDisplayOrder());

        Project updated = projectRepository.save(project);
        return ProjectMapper.toDto(updated);
    }

    public void deleteProject(Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Project", "id", id));
        projectRepository.delete(project);
    }
}

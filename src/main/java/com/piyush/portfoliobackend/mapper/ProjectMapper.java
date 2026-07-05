package com.piyush.portfoliobackend.mapper;

import com.piyush.portfoliobackend.dto.ProjectDto;
import com.piyush.portfoliobackend.entity.Project;

public class ProjectMapper {

    public static Project toEntity(ProjectDto dto) {
        if (dto == null) return null;
        return Project.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .shortDescription(dto.getShortDescription())
                .longDescription(dto.getLongDescription())
                .technologies(dto.getTechnologies())
                .githubUrl(dto.getGithubUrl())
                .liveUrl(dto.getLiveUrl())
                .imageUrl(dto.getImageUrl())
                .featured(dto.isFeatured())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public static ProjectDto toDto(Project entity) {
        if (entity == null) return null;
        return ProjectDto.builder()
                .id(entity.getId())
                .title(entity.getTitle())
                .shortDescription(entity.getShortDescription())
                .longDescription(entity.getLongDescription())
                .technologies(entity.getTechnologies())
                .githubUrl(entity.getGithubUrl())
                .liveUrl(entity.getLiveUrl())
                .imageUrl(entity.getImageUrl())
                .featured(entity.isFeatured())
                .displayOrder(entity.getDisplayOrder())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}

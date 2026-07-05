package com.piyush.portfoliobackend.mapper;

import com.piyush.portfoliobackend.dto.EducationDto;
import com.piyush.portfoliobackend.entity.Education;

public class EducationMapper {

    public static Education toEntity(EducationDto dto) {
        if (dto == null) return null;
        return Education.builder()
                .id(dto.getId())
                .institution(dto.getInstitution())
                .degree(dto.getDegree())
                .fieldOfStudy(dto.getFieldOfStudy())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .grade(dto.getGrade())
                .description(dto.getDescription())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public static EducationDto toDto(Education entity) {
        if (entity == null) return null;
        return EducationDto.builder()
                .id(entity.getId())
                .institution(entity.getInstitution())
                .degree(entity.getDegree())
                .fieldOfStudy(entity.getFieldOfStudy())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .grade(entity.getGrade())
                .description(entity.getDescription())
                .displayOrder(entity.getDisplayOrder())
                .build();
    }
}

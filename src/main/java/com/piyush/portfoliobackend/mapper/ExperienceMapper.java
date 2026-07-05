package com.piyush.portfoliobackend.mapper;

import com.piyush.portfoliobackend.dto.ExperienceDto;
import com.piyush.portfoliobackend.entity.Experience;

public class ExperienceMapper {

    public static Experience toEntity(ExperienceDto dto) {
        if (dto == null) return null;
        return Experience.builder()
                .id(dto.getId())
                .company(dto.getCompany())
                .position(dto.getPosition())
                .location(dto.getLocation())
                .startDate(dto.getStartDate())
                .endDate(dto.getEndDate())
                .current(dto.isCurrent())
                .description(dto.getDescription())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public static ExperienceDto toDto(Experience entity) {
        if (entity == null) return null;
        return ExperienceDto.builder()
                .id(entity.getId())
                .company(entity.getCompany())
                .position(entity.getPosition())
                .location(entity.getLocation())
                .startDate(entity.getStartDate())
                .endDate(entity.getEndDate())
                .current(entity.isCurrent())
                .description(entity.getDescription())
                .displayOrder(entity.getDisplayOrder())
                .build();
    }
}

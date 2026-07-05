package com.piyush.portfoliobackend.mapper;

import com.piyush.portfoliobackend.dto.SkillDto;
import com.piyush.portfoliobackend.entity.Skill;

public class SkillMapper {

    public static Skill toEntity(SkillDto dto) {
        if (dto == null) return null;
        return Skill.builder()
                .id(dto.getId())
                .name(dto.getName())
                .category(dto.getCategory())
                .proficiencyLevel(dto.getProficiencyLevel())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public static SkillDto toDto(Skill entity) {
        if (entity == null) return null;
        return SkillDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory())
                .proficiencyLevel(entity.getProficiencyLevel())
                .displayOrder(entity.getDisplayOrder())
                .build();
    }
}

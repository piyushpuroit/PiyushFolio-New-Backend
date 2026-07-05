package com.piyush.portfoliobackend.mapper;

import com.piyush.portfoliobackend.dto.ResumeDto;
import com.piyush.portfoliobackend.entity.Resume;

public class ResumeMapper {

    public static Resume toEntity(ResumeDto dto) {
        if (dto == null) return null;
        return Resume.builder()
                .downloadUrl(dto.getDownloadUrl())
                .build();
    }

    public static ResumeDto toDto(Resume entity) {
        if (entity == null) return null;
        return ResumeDto.builder()
                .downloadUrl(entity.getDownloadUrl())
                .lastUpdated(entity.getLastUpdated())
                .build();
    }
}

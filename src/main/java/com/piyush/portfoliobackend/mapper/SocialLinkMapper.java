package com.piyush.portfoliobackend.mapper;

import com.piyush.portfoliobackend.dto.SocialLinkDto;
import com.piyush.portfoliobackend.entity.SocialLink;

public class SocialLinkMapper {

    public static SocialLink toEntity(SocialLinkDto dto) {
        if (dto == null) return null;
        return SocialLink.builder()
                .id(dto.getId())
                .platformName(dto.getPlatformName())
                .url(dto.getUrl())
                .icon(dto.getIcon())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public static SocialLinkDto toDto(SocialLink entity) {
        if (entity == null) return null;
        return SocialLinkDto.builder()
                .id(entity.getId())
                .platformName(entity.getPlatformName())
                .url(entity.getUrl())
                .icon(entity.getIcon())
                .displayOrder(entity.getDisplayOrder())
                .build();
    }
}

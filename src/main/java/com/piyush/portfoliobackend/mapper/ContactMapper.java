package com.piyush.portfoliobackend.mapper;

import com.piyush.portfoliobackend.dto.ContactRequestDto;
import com.piyush.portfoliobackend.dto.ContactResponseDto;
import com.piyush.portfoliobackend.entity.Contact;

public class ContactMapper {

    public static Contact toEntity(ContactRequestDto dto) {
        if (dto == null) return null;
        return Contact.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .subject(dto.getSubject())
                .phone(dto.getPhone())
                .message(dto.getMessage())
                .read(false)
                .build();
    }

    public static ContactResponseDto toDto(Contact entity) {
        if (entity == null) return null;
        return ContactResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .subject(entity.getSubject())
                .phone(entity.getPhone())
                .message(entity.getMessage())
                .read(entity.getRead())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .build();
    }
}

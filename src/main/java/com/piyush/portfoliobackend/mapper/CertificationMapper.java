package com.piyush.portfoliobackend.mapper;

import com.piyush.portfoliobackend.dto.CertificationDto;
import com.piyush.portfoliobackend.entity.Certification;

public class CertificationMapper {

    public static Certification toEntity(CertificationDto dto) {
        if (dto == null) return null;
        return Certification.builder()
                .id(dto.getId())
                .name(dto.getName())
                .issuingOrganization(dto.getIssuingOrganization())
                .issueDate(dto.getIssueDate())
                .expirationDate(dto.getExpirationDate())
                .credentialId(dto.getCredentialId())
                .credentialUrl(dto.getCredentialUrl())
                .displayOrder(dto.getDisplayOrder())
                .build();
    }

    public static CertificationDto toDto(Certification entity) {
        if (entity == null) return null;
        return CertificationDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .issuingOrganization(entity.getIssuingOrganization())
                .issueDate(entity.getIssueDate())
                .expirationDate(entity.getExpirationDate())
                .credentialId(entity.getCredentialId())
                .credentialUrl(entity.getCredentialUrl())
                .displayOrder(entity.getDisplayOrder())
                .build();
    }
}

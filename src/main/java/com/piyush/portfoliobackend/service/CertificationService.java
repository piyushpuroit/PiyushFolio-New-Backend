package com.piyush.portfoliobackend.service;

import com.piyush.portfoliobackend.dto.CertificationDto;
import com.piyush.portfoliobackend.entity.Certification;
import com.piyush.portfoliobackend.exception.ResourceNotFoundException;
import com.piyush.portfoliobackend.mapper.CertificationMapper;
import com.piyush.portfoliobackend.repository.CertificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CertificationService {

    private final CertificationRepository certificationRepository;

    public CertificationService(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    public CertificationDto createCertification(CertificationDto certificationDto) {
        Certification certification = CertificationMapper.toEntity(certificationDto);
        Certification saved = certificationRepository.save(certification);
        return CertificationMapper.toDto(saved);
    }

    public List<CertificationDto> getAllCertifications() {
        return certificationRepository.findAllByOrderByDisplayOrderAsc().stream()
                .map(CertificationMapper::toDto)
                .collect(Collectors.toList());
    }

    public CertificationDto getCertificationById(Long id) {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification", "id", id));
        return CertificationMapper.toDto(certification);
    }

    public CertificationDto updateCertification(Long id, CertificationDto certificationDto) {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification", "id", id));

        certification.setName(certificationDto.getName());
        certification.setIssuingOrganization(certificationDto.getIssuingOrganization());
        certification.setIssueDate(certificationDto.getIssueDate());
        certification.setExpirationDate(certificationDto.getExpirationDate());
        certification.setCredentialId(certificationDto.getCredentialId());
        certification.setCredentialUrl(certificationDto.getCredentialUrl());
        certification.setDisplayOrder(certificationDto.getDisplayOrder());

        Certification updated = certificationRepository.save(certification);
        return CertificationMapper.toDto(updated);
    }

    public void deleteCertification(Long id) {
        Certification certification = certificationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Certification", "id", id));
        certificationRepository.delete(certification);
    }
}

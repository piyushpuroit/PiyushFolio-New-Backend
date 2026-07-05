package com.piyush.portfoliobackend.service;

import com.piyush.portfoliobackend.dto.EducationDto;
import com.piyush.portfoliobackend.entity.Education;
import com.piyush.portfoliobackend.exception.ResourceNotFoundException;
import com.piyush.portfoliobackend.mapper.EducationMapper;
import com.piyush.portfoliobackend.repository.EducationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EducationService {

    private final EducationRepository educationRepository;

    public EducationService(EducationRepository educationRepository) {
        this.educationRepository = educationRepository;
    }

    public EducationDto createEducation(EducationDto educationDto) {
        Education education = EducationMapper.toEntity(educationDto);
        Education saved = educationRepository.save(education);
        return EducationMapper.toDto(saved);
    }

    public List<EducationDto> getAllEducation() {
        return educationRepository.findAllByOrderByDisplayOrderAsc().stream()
                .map(EducationMapper::toDto)
                .collect(Collectors.toList());
    }

    public EducationDto getEducationById(Long id) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Education", "id", id));
        return EducationMapper.toDto(education);
    }

    public EducationDto updateEducation(Long id, EducationDto educationDto) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Education", "id", id));

        education.setInstitution(educationDto.getInstitution());
        education.setDegree(educationDto.getDegree());
        education.setFieldOfStudy(educationDto.getFieldOfStudy());
        education.setStartDate(educationDto.getStartDate());
        education.setEndDate(educationDto.getEndDate());
        education.setGrade(educationDto.getGrade());
        education.setDescription(educationDto.getDescription());
        education.setDisplayOrder(educationDto.getDisplayOrder());

        Education updated = educationRepository.save(education);
        return EducationMapper.toDto(updated);
    }

    public void deleteEducation(Long id) {
        Education education = educationRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Education", "id", id));
        educationRepository.delete(education);
    }
}

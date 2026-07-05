package com.piyush.portfoliobackend.service;

import com.piyush.portfoliobackend.dto.ExperienceDto;
import com.piyush.portfoliobackend.entity.Experience;
import com.piyush.portfoliobackend.exception.ResourceNotFoundException;
import com.piyush.portfoliobackend.mapper.ExperienceMapper;
import com.piyush.portfoliobackend.repository.ExperienceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExperienceService {

    private final ExperienceRepository experienceRepository;

    public ExperienceService(ExperienceRepository experienceRepository) {
        this.experienceRepository = experienceRepository;
    }

    public ExperienceDto createExperience(ExperienceDto experienceDto) {
        Experience experience = ExperienceMapper.toEntity(experienceDto);
        Experience saved = experienceRepository.save(experience);
        return ExperienceMapper.toDto(saved);
    }

    public List<ExperienceDto> getAllExperiences() {
        return experienceRepository.findAllByOrderByDisplayOrderAsc().stream()
                .map(ExperienceMapper::toDto)
                .collect(Collectors.toList());
    }

    public ExperienceDto getExperienceById(Long id) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Experience", "id", id));
        return ExperienceMapper.toDto(experience);
    }

    public ExperienceDto updateExperience(Long id, ExperienceDto experienceDto) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Experience", "id", id));

        experience.setCompany(experienceDto.getCompany());
        experience.setPosition(experienceDto.getPosition());
        experience.setLocation(experienceDto.getLocation());
        experience.setStartDate(experienceDto.getStartDate());
        experience.setEndDate(experienceDto.getEndDate());
        experience.setCurrent(experienceDto.isCurrent());
        experience.setDescription(experienceDto.getDescription());
        experience.setDisplayOrder(experienceDto.getDisplayOrder());

        Experience updated = experienceRepository.save(experience);
        return ExperienceMapper.toDto(updated);
    }

    public void deleteExperience(Long id) {
        Experience experience = experienceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Experience", "id", id));
        experienceRepository.delete(experience);
    }
}

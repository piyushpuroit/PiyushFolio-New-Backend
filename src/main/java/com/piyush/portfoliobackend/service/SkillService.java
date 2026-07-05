package com.piyush.portfoliobackend.service;

import com.piyush.portfoliobackend.dto.SkillDto;
import com.piyush.portfoliobackend.entity.Skill;
import com.piyush.portfoliobackend.exception.ResourceNotFoundException;
import com.piyush.portfoliobackend.mapper.SkillMapper;
import com.piyush.portfoliobackend.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public SkillDto createSkill(SkillDto skillDto) {
        Skill skill = SkillMapper.toEntity(skillDto);
        Skill saved = skillRepository.save(skill);
        return SkillMapper.toDto(saved);
    }

    public List<SkillDto> getAllSkills() {
        return skillRepository.findAllByOrderByDisplayOrderAsc().stream()
                .map(SkillMapper::toDto)
                .collect(Collectors.toList());
    }

    public SkillDto getSkillById(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));
        return SkillMapper.toDto(skill);
    }

    public SkillDto updateSkill(Long id, SkillDto skillDto) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));

        skill.setName(skillDto.getName());
        skill.setCategory(skillDto.getCategory());
        skill.setProficiencyLevel(skillDto.getProficiencyLevel());
        skill.setDisplayOrder(skillDto.getDisplayOrder());

        Skill updated = skillRepository.save(skill);
        return SkillMapper.toDto(updated);
    }

    public void deleteSkill(Long id) {
        Skill skill = skillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Skill", "id", id));
        skillRepository.delete(skill);
    }
}

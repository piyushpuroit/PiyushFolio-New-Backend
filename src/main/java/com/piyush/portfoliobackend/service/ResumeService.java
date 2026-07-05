package com.piyush.portfoliobackend.service;

import com.piyush.portfoliobackend.dto.ResumeDto;
import com.piyush.portfoliobackend.entity.Resume;
import com.piyush.portfoliobackend.mapper.ResumeMapper;
import com.piyush.portfoliobackend.repository.ResumeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ResumeService {

    private final ResumeRepository resumeRepository;

    public ResumeService(ResumeRepository resumeRepository) {
        this.resumeRepository = resumeRepository;
    }

    public ResumeDto getResume() {
        Resume resume = resumeRepository.findById(1L).orElseGet(() -> {
            Resume defaultResume = Resume.builder()
                    .downloadUrl("https://example.com/resume.pdf")
                    .lastUpdated(LocalDateTime.now())
                    .build();
            defaultResume.setId(1L);
            return resumeRepository.save(defaultResume);
        });
        return ResumeMapper.toDto(resume);
    }

    public ResumeDto updateResume(ResumeDto resumeDto) {
        Resume resume = resumeRepository.findById(1L).orElseGet(() -> {
            Resume defaultResume = new Resume();
            defaultResume.setId(1L);
            return defaultResume;
        });
        resume.setDownloadUrl(resumeDto.getDownloadUrl());
        Resume updated = resumeRepository.save(resume);
        return ResumeMapper.toDto(updated);
    }
}

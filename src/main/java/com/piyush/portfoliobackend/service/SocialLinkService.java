package com.piyush.portfoliobackend.service;

import com.piyush.portfoliobackend.dto.SocialLinkDto;
import com.piyush.portfoliobackend.entity.SocialLink;
import com.piyush.portfoliobackend.exception.ResourceNotFoundException;
import com.piyush.portfoliobackend.mapper.SocialLinkMapper;
import com.piyush.portfoliobackend.repository.SocialLinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SocialLinkService {

    private final SocialLinkRepository socialLinkRepository;

    public SocialLinkService(SocialLinkRepository socialLinkRepository) {
        this.socialLinkRepository = socialLinkRepository;
    }

    public SocialLinkDto createSocialLink(SocialLinkDto socialLinkDto) {
        SocialLink socialLink = SocialLinkMapper.toEntity(socialLinkDto);
        SocialLink saved = socialLinkRepository.save(socialLink);
        return SocialLinkMapper.toDto(saved);
    }

    public List<SocialLinkDto> getAllSocialLinks() {
        return socialLinkRepository.findAllByOrderByDisplayOrderAsc().stream()
                .map(SocialLinkMapper::toDto)
                .collect(Collectors.toList());
    }

    public SocialLinkDto getSocialLinkById(Long id) {
        SocialLink socialLink = socialLinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SocialLink", "id", id));
        return SocialLinkMapper.toDto(socialLink);
    }

    public SocialLinkDto updateSocialLink(Long id, SocialLinkDto socialLinkDto) {
        SocialLink socialLink = socialLinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SocialLink", "id", id));

        socialLink.setPlatformName(socialLinkDto.getPlatformName());
        socialLink.setUrl(socialLinkDto.getUrl());
        socialLink.setIcon(socialLinkDto.getIcon());
        socialLink.setDisplayOrder(socialLinkDto.getDisplayOrder());

        SocialLink updated = socialLinkRepository.save(socialLink);
        return SocialLinkMapper.toDto(updated);
    }

    public void deleteSocialLink(Long id) {
        SocialLink socialLink = socialLinkRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("SocialLink", "id", id));
        socialLinkRepository.delete(socialLink);
    }
}

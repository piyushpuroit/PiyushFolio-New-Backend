package com.piyush.portfoliobackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialLinkDto {
    private Long id;

    @NotBlank(message = "Platform name is required")
    private String platformName;

    @NotBlank(message = "URL is required")
    private String url;

    private String icon;

    private int displayOrder;
}

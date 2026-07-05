package com.piyush.portfoliobackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "social_links")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SocialLink {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Platform name is required")
    private String platformName; // e.g. "GitHub", "LinkedIn"

    @NotBlank(message = "URL is required")
    private String url;

    private String icon; // Icon identifier (e.g. fontawesome name)

    @Builder.Default
    private int displayOrder = 0;
}

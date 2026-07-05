package com.piyush.portfoliobackend.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {
    private Long id;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Short description is required")
    private String shortDescription;

    private String longDescription;

    private String technologies;

    private String githubUrl;

    private String liveUrl;

    private String imageUrl;

    private boolean featured;

    private int displayOrder;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

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
public class ResumeDto {
    @NotBlank(message = "Download URL is required")
    private String downloadUrl;
    private LocalDateTime lastUpdated;
}

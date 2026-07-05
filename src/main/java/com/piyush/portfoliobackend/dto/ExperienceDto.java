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
public class ExperienceDto {
    private Long id;

    @NotBlank(message = "Company is required")
    private String company;

    @NotBlank(message = "Position is required")
    private String position;

    private String location;

    @NotBlank(message = "Start date is required")
    private String startDate;

    private String endDate;

    private boolean current;

    private String description;

    private int displayOrder;
}

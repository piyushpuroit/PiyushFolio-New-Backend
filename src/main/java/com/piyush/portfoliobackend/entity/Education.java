package com.piyush.portfoliobackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "education")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Institution is required")
    private String institution;

    @NotBlank(message = "Degree is required")
    private String degree;

    @NotBlank(message = "Field of study is required")
    private String fieldOfStudy;

    @NotBlank(message = "Start date is required")
    private String startDate; // e.g. "2020", "Sep 2020"

    private String endDate; // e.g. "2024", "Present"

    private String grade; // e.g. "CGPA 9.5" or "Grade A"

    @Column(columnDefinition = "TEXT")
    private String description;

    @Builder.Default
    private int displayOrder = 0;
}

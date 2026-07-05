package com.piyush.portfoliobackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "experiences")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Company is required")
    private String company;

    @NotBlank(message = "Position is required")
    private String position;

    private String location;

    @NotBlank(message = "Start date is required")
    private String startDate;

    private String endDate;

    @Builder.Default
    private boolean current = false;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Builder.Default
    private int displayOrder = 0;
}

package com.piyush.portfoliobackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "certifications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Certification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Certification name is required")
    private String name;

    @NotBlank(message = "Issuing organization is required")
    private String issuingOrganization;

    @NotBlank(message = "Issue date is required")
    private String issueDate; // e.g. "Jan 2024" or "2024-01-15"

    private String expirationDate;

    private String credentialId;

    private String credentialUrl;

    @Builder.Default
    private int displayOrder = 0;
}

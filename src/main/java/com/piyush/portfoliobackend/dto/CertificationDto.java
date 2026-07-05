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
public class CertificationDto {
    private Long id;

    @NotBlank(message = "Certification name is required")
    private String name;

    @NotBlank(message = "Issuing organization is required")
    private String issuingOrganization;

    @NotBlank(message = "Issue date is required")
    private String issueDate;

    private String expirationDate;

    private String credentialId;

    private String credentialUrl;

    private int displayOrder;
}

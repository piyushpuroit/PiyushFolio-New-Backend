package com.piyush.portfoliobackend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "resumes")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resume {

    @Id
    @Builder.Default
    private Long id = 1L; // Always 1 since there is only one resume configuration

    @NotBlank(message = "Download URL is required")
    private String downloadUrl;

    private LocalDateTime lastUpdated;

    @PrePersist
    @PreUpdate
    protected void onSave() {
        this.lastUpdated = LocalDateTime.now();
    }
}

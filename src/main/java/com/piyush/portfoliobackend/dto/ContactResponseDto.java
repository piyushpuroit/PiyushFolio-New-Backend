package com.piyush.portfoliobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponseDto {
    private Long id;
    private String name;
    private String email;
    private String subject;
    private String phone;
    private String message;
    private Boolean read;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

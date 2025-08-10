package com.imam.moneymate.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileDTO {
    private Long id;

    private String fullName;

    private String email;

    private String password;

    private String profileImageURL;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}

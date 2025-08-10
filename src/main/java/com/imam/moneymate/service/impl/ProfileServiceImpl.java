package com.imam.moneymate.service.impl;

import com.imam.moneymate.dto.ProfileDTO;
import com.imam.moneymate.entity.Profile;
import com.imam.moneymate.repository.ProfileRepository;
import com.imam.moneymate.service.EmailService;
import com.imam.moneymate.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {

    private final ProfileRepository profileRepository;
    private final EmailService emailService;

    @Override
    public ProfileDTO registerProfile(ProfileDTO profileDTO) {
        Profile newProfile = toEntity(profileDTO);
        newProfile.setActivationToken(UUID.randomUUID().toString());
        newProfile = profileRepository.save(newProfile);

        //send Activation email
        String activationLink = "http://localhost:8080/api/v1/activate?token=" + newProfile.getActivationToken();
        String subject = "Activate you money mate account";
        String body = "Click on the following link to activate your account " + activationLink;
        emailService.sendEmail(newProfile.getEmail(), subject, body);
        return toDTO(newProfile);
    }

    public Profile toEntity(ProfileDTO profileDTO){

        return Profile.builder()
                .id(profileDTO.getId())
                .fullName(profileDTO.getFullName())
                .email(profileDTO.getEmail())
                .password(profileDTO.getPassword())
                .profileImageURL(profileDTO.getProfileImageURL())
                .createdAt(profileDTO.getCreatedAt())
                .updatedAt(profileDTO.getUpdatedAt())
                .build();
    }

    public ProfileDTO toDTO(Profile profile){

        return ProfileDTO.builder()
                .id(profile.getId())
                .fullName(profile.getFullName())
                .email(profile.getEmail())
                .profileImageURL(profile.getProfileImageURL())
                .createdAt(profile.getCreatedAt())
                .updatedAt(profile.getUpdatedAt())
                .build();
    }

    public Boolean activateToken(String activationToken) {

        return profileRepository.findByActivationToken(activationToken)
                .map(profile -> {
                    profile.setIsActive(true);
                    profileRepository.save(profile);
                    return true;
                })
                .orElse(false);
    }
}

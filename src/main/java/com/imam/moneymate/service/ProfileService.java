package com.imam.moneymate.service;

import com.imam.moneymate.dto.ProfileDTO;

public interface ProfileService {

    public ProfileDTO registerProfile(ProfileDTO profileDTO);

    public Boolean activateToken(String activationToken);
}

package com.imam.moneymate.service.impl;

import com.imam.moneymate.dto.IncomeDTO;
import com.imam.moneymate.entity.Category;
import com.imam.moneymate.entity.Income;
import com.imam.moneymate.entity.Profile;
import com.imam.moneymate.repository.CategoryRepository;
import com.imam.moneymate.repository.IncomeRepository;
import com.imam.moneymate.service.IncomeService;
import com.imam.moneymate.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class IncomeServiceImpl implements IncomeService {

    private final CategoryRepository categoryRepository;

    private final IncomeRepository incomeRepository;

    private final ProfileService profileService;

    public IncomeDTO addIncome(IncomeDTO dto) {
        Profile profile = profileService.getcurrentProfile();
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Income newIncome = toEntity(dto, profile,category);
        newIncome = incomeRepository.save(newIncome);

        return toDTO(newIncome);
    }

    private Income toEntity(IncomeDTO dto, Profile profile, Category category) {

        return Income.builder()
                .name(dto.getName())
                .icon(dto.getIcon())
                .amount(dto.getAmount())
                .date(dto.getDate())
                .profile(profile)
                .category(category)
                .build();
    }

    private IncomeDTO toDTO(Income income) {

        return IncomeDTO.builder()
                .id(income.getId())
                .name(income.getName())
                .icon(income.getIcon())
                .categoryId(income.getCategory() != null ? income.getCategory().getId() : null)
                .categoryName(income.getCategory() != null ? income.getCategory().getName() : "N/A")
                .amount(income.getAmount())
                .date(income.getDate())
                .createdAt(income.getCreatedAt())
                .updatedAt(income.getUpdatedAt())
                .build();
    }
}

package com.imam.moneymate.service.impl;

import com.imam.moneymate.dto.ExpenseDTO;
import com.imam.moneymate.entity.Category;
import com.imam.moneymate.entity.Expense;
import com.imam.moneymate.entity.Profile;
import com.imam.moneymate.repository.CategoryRepository;
import com.imam.moneymate.repository.ExpenseRepository;
import com.imam.moneymate.service.CategoryService;
import com.imam.moneymate.service.ExpenseService;
import com.imam.moneymate.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {

    private final CategoryRepository categoryRepository;

    private final ExpenseRepository expenseRepository;

    private final ProfileService profileService;

    public ExpenseDTO addExpense(ExpenseDTO dto) {
        Profile profile = profileService.getcurrentProfile();
        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Expense newExpense = toEntity(dto, profile,category);
        newExpense = expenseRepository.save(newExpense);

        return toDTO(newExpense);
    }

    private Expense toEntity(ExpenseDTO dto, Profile profile, Category category) {

        return Expense.builder()
                .name(dto.getName())
                .icon(dto.getIcon())
                .amount(dto.getAmount())
                .date(dto.getDate())
                .profile(profile)
                .category(category)
                .build();
    }

    private ExpenseDTO toDTO(Expense expense) {

        return ExpenseDTO.builder()
                .id(expense.getId())
                .name(expense.getName())
                .icon(expense.getIcon())
                .categoryId(expense.getCategory() != null ? expense.getCategory().getId() : null)
                .categoryName(expense.getCategory() != null ? expense.getCategory().getName() : "N/A")
                .amount(expense.getAmount())
                .date(expense.getDate())
                .createdAt(expense.getCreatedAt())
                .updatedAt(expense.getUpdatedAt())
                .build();
    }
}

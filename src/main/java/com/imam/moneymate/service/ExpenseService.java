package com.imam.moneymate.service;

import com.imam.moneymate.dto.ExpenseDTO;

import java.util.List;

public interface ExpenseService {
    public ExpenseDTO addExpense(ExpenseDTO dto);

    public List<ExpenseDTO> getCurrentMonthExpense();
}

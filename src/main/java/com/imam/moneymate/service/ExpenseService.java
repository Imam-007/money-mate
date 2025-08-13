package com.imam.moneymate.service;

import com.imam.moneymate.dto.ExpenseDTO;

import java.math.BigDecimal;
import java.util.List;

public interface ExpenseService {
    public ExpenseDTO addExpense(ExpenseDTO dto);

    public List<ExpenseDTO> getCurrentMonthExpense();

    public void deleteExpense(Long expenseId);

    public List<ExpenseDTO> getLatest5Expenses();

    public BigDecimal getTotalExpense();
}

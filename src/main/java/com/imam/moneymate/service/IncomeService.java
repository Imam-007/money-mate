package com.imam.moneymate.service;

import com.imam.moneymate.dto.IncomeDTO;

import java.math.BigDecimal;
import java.util.List;

public interface IncomeService {
    public IncomeDTO addIncome(IncomeDTO dto);

    public List<IncomeDTO> getCurrentMonthIncome();

    public void deleteIncome(Long incomeId);

    public List<IncomeDTO> getLatest5Incomes();

    public BigDecimal getTotalIncomes();
}

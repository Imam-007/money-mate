package com.imam.moneymate.service;

import com.imam.moneymate.dto.IncomeDTO;

import java.util.List;

public interface IncomeService {
    public IncomeDTO addIncome(IncomeDTO dto);

    public List<IncomeDTO> getCurrentMonthIncome();
}

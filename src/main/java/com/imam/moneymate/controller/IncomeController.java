package com.imam.moneymate.controller;

import com.imam.moneymate.dto.ExpenseDTO;
import com.imam.moneymate.dto.IncomeDTO;
import com.imam.moneymate.service.IncomeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/incomes")
public class IncomeController {
    private final IncomeService incomeService;

    @PostMapping
    public ResponseEntity<IncomeDTO> addExpense(@RequestBody IncomeDTO expenseDTO) {
        IncomeDTO saved = incomeService.addIncome(expenseDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }
}

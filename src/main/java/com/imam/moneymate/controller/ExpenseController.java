package com.imam.moneymate.controller;

import com.imam.moneymate.dto.ExpenseDTO;
import com.imam.moneymate.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDTO> addExpense(@RequestBody ExpenseDTO expenseDTO) {
        ExpenseDTO saved = expenseService.addExpense(expenseDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDTO>> getExpense() {
        List<ExpenseDTO> expenses = expenseService.getCurrentMonthExpense();

        return ResponseEntity.ok(expenses);
    }
}

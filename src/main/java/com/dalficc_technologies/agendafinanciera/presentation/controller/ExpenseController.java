package com.dalficc_technologies.agendafinanciera.presentation.controller;

import com.dalficc_technologies.agendafinanciera.application.service.GetUserExpensesService;
import com.dalficc_technologies.agendafinanciera.domain.model.Expense;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/v1/expenses")
public class ExpenseController {

    @Autowired
    private GetUserExpensesService getUserExpensesService;

    @GetMapping("/{userId}")
    public List<Expense> getExpenses(@PathVariable String userId) throws ExecutionException, InterruptedException {
        return getUserExpensesService.execute(userId);
    }
}
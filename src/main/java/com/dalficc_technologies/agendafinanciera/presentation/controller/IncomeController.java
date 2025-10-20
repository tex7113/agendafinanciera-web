package com.dalficc_technologies.agendafinanciera.presentation.controller;

import com.dalficc_technologies.agendafinanciera.application.service.GetUserIncomesService;
import com.dalficc_technologies.agendafinanciera.domain.model.Income;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/v1/incomes")
public class IncomeController {

    @Autowired
    private GetUserIncomesService getUserIncomesService;

    @GetMapping("/{userId}")
    public List<Income> getIncomes(@PathVariable String userId) throws ExecutionException, InterruptedException {
        return getUserIncomesService.getIcomes(userId);
    }
}

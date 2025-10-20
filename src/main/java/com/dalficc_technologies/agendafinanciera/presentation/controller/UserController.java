package com.dalficc_technologies.agendafinanciera.presentation.controller;

import com.dalficc_technologies.agendafinanciera.application.service.GetUserService;
import com.dalficc_technologies.agendafinanciera.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private GetUserService getUserService;

    @GetMapping("/{userId}")
    public User getCurrentUser(@PathVariable String userId) throws ExecutionException, InterruptedException {
        return getUserService.getUser(userId);
    }
}

package com.dalficc_technologies.agendafinanciera.domain.model;

import lombok.Data;

@Data
public class UserLoginRequest {
    private String email;
    private String password;
}

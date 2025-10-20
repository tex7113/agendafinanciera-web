package com.dalficc_technologies.agendafinanciera.domain.model;

import lombok.Data;

@Data
public class User {

    private String id;
    private String name;
    private String email;
    private String createdAt;
}

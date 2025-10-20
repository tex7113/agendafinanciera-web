package com.dalficc_technologies.agendafinanciera.domain.model;

import lombok.Data;

@Data
public class Expense {
    private String id;
    private Double amount;
    private String description;
    private String date;
    //private Long date;
}

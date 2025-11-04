package com.dalficc_technologies.agendafinanciera.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {

    @GetMapping("/contacto")
    public String contact() { return "contact"; }
}

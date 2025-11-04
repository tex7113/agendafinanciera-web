package com.dalficc_technologies.agendafinanciera.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class infoController {

    @GetMapping("/quienes-somos")
    public String about() { return "about"; }

    @GetMapping("/servicios")
    public String services() { return "services"; }
}

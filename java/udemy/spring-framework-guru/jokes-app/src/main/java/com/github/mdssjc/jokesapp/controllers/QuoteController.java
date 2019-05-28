package com.github.mdssjc.jokesapp.controllers;

import com.github.mdssjc.jokesapp.services.QuoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class QuoteController {

    private QuoteService service;

    public QuoteController(QuoteService service) {
        this.service = service;
    }

    @GetMapping({"/", ""})
    public String root(Model model) {
        model.addAttribute("joke", service.quote());
        return "chucknorris";
    }
}

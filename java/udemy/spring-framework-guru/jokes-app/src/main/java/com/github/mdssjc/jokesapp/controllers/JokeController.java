package com.github.mdssjc.jokesapp.controllers;

import com.github.mdssjc.jokesapp.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JokeController {

    private JokeService service;

    public JokeController(JokeService service) {
        this.service = service;
    }

    @GetMapping({"/", ""})
    public String root(Model model) {
        model.addAttribute("joke", service.getJoke());
        return "chucknorris";
    }
}

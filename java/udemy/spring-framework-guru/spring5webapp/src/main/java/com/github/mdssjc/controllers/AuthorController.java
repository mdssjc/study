package com.github.mdssjc.controllers;

import com.github.mdssjc.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthorController {

    private AuthorRepository repository;

    public AuthorController(AuthorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/authors")
    public String authors(Model model) {
        model.addAttribute("authors", repository.findAll());

        return "authors";
    }
}

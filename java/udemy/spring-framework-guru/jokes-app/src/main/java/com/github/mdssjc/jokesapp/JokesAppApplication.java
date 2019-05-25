package com.github.mdssjc.jokesapp;

import com.github.mdssjc.jokesapp.services.QuoteService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JokesAppApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(JokesAppApplication.class, args);

        QuoteService bean = context.getBean(QuoteService.class);
        System.out.println(bean.quote());
    }
}

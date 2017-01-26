package com.github.mdssjc.tarefas.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.Callable;

@Controller
public class AsyncController {

  @RequestMapping("egg")
  public Callable<String> easterEgg() {
    return () -> {
      try {
        Thread.sleep(3000);
      } catch (final InterruptedException e) {
        e.printStackTrace();
      }
      return "secret";
    };
  }
}

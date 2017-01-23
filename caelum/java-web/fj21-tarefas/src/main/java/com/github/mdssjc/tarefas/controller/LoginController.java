package com.github.mdssjc.tarefas.controller;

import com.github.mdssjc.tarefas.entity.User;
import com.github.mdssjc.tarefas.persistence.UserDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

  @RequestMapping("login")
  public String form() {
    return "login";
  }

  @RequestMapping("doLogin")
  public String login(User user, HttpSession session) {
    if (new UserDAO().checkUser(user)) {
      session.setAttribute("validUser", user);
      return "menu";
    }
    return "redirect:login";
  }

  @RequestMapping("logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:login";
  }
}

package com.github.mdssjc.fj21_agenda.mvc.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NullLogic implements LogicCommand {

  @Override
  public String execute(final HttpServletRequest request,
                        final HttpServletResponse response) throws Exception {
    System.out.println("Página inicial");

    return "index.jsp";
  }
}

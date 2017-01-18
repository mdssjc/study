package com.github.mdssjc.fj21_agenda.mvc.controller;

import com.github.mdssjc.fj21_agenda.mvc.command.LogicCommand;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet( "/do" )
public class FrontController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Override
  protected void service(final HttpServletRequest request, final HttpServletResponse response)
      throws ServletException, IOException {
    final Optional<String> parameter = Optional.ofNullable(request.getParameter("cmd"));
    final String className = "com.github.mdssjc.fj21_agenda.mvc.command." + parameter.orElse("NullLogic");

    try {
      final LogicCommand logic = (LogicCommand) Class.forName(className)
                                                     .newInstance();
      final String page = logic.execute(request, response);

      request.getRequestDispatcher(page)
             .forward(request, response);
    } catch (final Exception e) {
      throw new ServletException(e);
    }
  }
}

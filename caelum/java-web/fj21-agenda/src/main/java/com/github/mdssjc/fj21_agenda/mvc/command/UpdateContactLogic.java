package com.github.mdssjc.fj21_agenda.mvc.command;

import com.github.mdssjc.fj21_agenda.persistence.ContatoDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class UpdateContactLogic implements LogicCommand {

  @Override
  public String execute(final HttpServletRequest request,
                        final HttpServletResponse response) throws Exception {
    final Connection connection = (Connection) request.getAttribute("connection");
    final Long id = Long.parseLong(request.getParameter("id"));

    request.setAttribute("contato", new ContatoDAO(connection).findById(id));

    System.out.println("Recuperando o contato para atualizar.");

    return "index.jsp";
  }
}

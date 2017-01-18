package com.github.mdssjc.fj21_agenda.mvc.command;

import com.github.mdssjc.fj21_agenda.persistence.ContatoDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class ListContactLogic implements LogicCommand {

  @Override
  public String execute(final HttpServletRequest request,
                        final HttpServletResponse response) throws Exception {
    final Connection connection = (Connection) request.getAttribute("connection");
    request.setAttribute("contatos", new ContatoDAO(connection).getList());

    System.out.println("Listando contatos...");

    return "/WEB-INF/jsp/list-contacts.jsp";
  }
}

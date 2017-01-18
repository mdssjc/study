package com.github.mdssjc.fj21_agenda.mvc.command;

import com.github.mdssjc.fj21_agenda.entity.Contato;
import com.github.mdssjc.fj21_agenda.persistence.ContatoDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;

public class RemoveContactLogic implements LogicCommand {

  @Override
  public String execute(final HttpServletRequest request,
                        final HttpServletResponse response) throws Exception {
    final Connection connection = (Connection) request.getAttribute("connection");
    final long id = Long.parseLong(request.getParameter("id"));

    final Contato contact = new Contato();
    contact.setId(id);
    new ContatoDAO(connection).delete(contact);

    System.out.println("Excluindo contato... ");

    return "do?cmd=ListContactLogic";
  }
}

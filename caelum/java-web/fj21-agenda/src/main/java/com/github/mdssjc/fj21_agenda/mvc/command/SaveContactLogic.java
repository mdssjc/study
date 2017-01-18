package com.github.mdssjc.fj21_agenda.mvc.command;

import com.github.mdssjc.fj21_agenda.entity.Contato;
import com.github.mdssjc.fj21_agenda.persistence.ContatoDAO;
import com.github.mdssjc.fj21_agenda.persistence.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SaveContactLogic implements LogicCommand {

  @Override
  public String execute(final HttpServletRequest request,
                        final HttpServletResponse response) throws Exception {
    final String id = request.getParameter("id");
    final String nome = request.getParameter("nome");
    final String endereco = request.getParameter("endereco");
    final String email = request.getParameter("email");
    final String dataEmTexto = request.getParameter("dataNascimento");
    Calendar dataNascimento = null;

    try {
      final Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
      dataNascimento = Calendar.getInstance();
      dataNascimento.setTime(date);
    } catch (final ParseException e) {
      System.out.println("Erro de conversão da data");
      throw e;
    }

    final Contato contato = new Contato();
    contato.setNome(nome);
    contato.setEndereco(endereco);
    contato.setEmail(email);
    contato.setDataNascimento(dataNascimento);

    final Connection connection = (Connection) request.getAttribute("connection");
    final DAO<Contato> dao = new ContatoDAO(connection);
    if (id == null) {
      // add
      dao.save(contato);
      System.out.println("Contato adicionado.");
    } else {
      // update
      contato.setId(Long.parseLong(id));
      dao.set(contato);
      System.out.println("Contato atualizado.");
    }

    return "contato-adicionado.jsp";
  }
}

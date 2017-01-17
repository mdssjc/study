package com.github.mdssjc.fj21_jdbc.base;

import com.github.mdssjc.fj21_jdbc.entity.Contato;
import com.github.mdssjc.fj21_jdbc.jdbc.ContatoDAO;
import com.github.mdssjc.fj21_jdbc.jdbc.DAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JDBCExemplo {

  private static final String DATE = "dd/MM/yyyy";

  public static void main(final String[] args) {
    Contato contato = new Contato();
    contato.setNome("Caelum");
    contato.setEmail("contato@caelum.com.br");
    contato.setEndereco("R. Vergueiro 3185 cj57");
    contato.setDataNascimento(LocalDate.now());

    final DAO dao = new ContatoDAO();

    System.out.println("Add");
    dao.add(contato);

    System.out.println("List all");
    boolean first = true;
    for (final Contato c : dao.listAll()) {
      print(c);
      if (first) {
      contato = c;
      first=false;
      }
    }

    System.out.println("Get");
    print(dao.get(contato.getId()));

    System.out.println("Update");
    contato.setNome("Kaleum");
    dao.update(contato);

    System.out.println("Get");
    print(dao.get(contato.getId()));

    System.out.println("Remove");
    dao.remove(contato);

    System.out.println("List all");
    for (final Contato c : dao.listAll()) {
      print(c);
    }
  }

  private static void print(final Contato contato) {
    final String dateGet = contato.getDataNascimento()
                                  .format(DateTimeFormatter.ofPattern(DATE));
    System.out.println("Nome: " + contato.getNome());
    System.out.println("Email: " + contato.getEmail());
    System.out.println("Endereço: " + contato.getEndereco());
    System.out.println("Data de Nascimento: " + dateGet + "\n");
  }
}

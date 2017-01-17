package com.github.mdssjc.fj21_jdbc.base;

import com.github.mdssjc.fj21_jdbc.entity.Contato;
import com.github.mdssjc.fj21_jdbc.jdbc.ContatoDAO;
import com.github.mdssjc.fj21_jdbc.jdbc.DAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class JDBCExemplo {

  private static final String DATE = "dd/MM/yyyy";

  public static void main(final String[] args) {
    final Contato contato = new Contato();
    contato.setNome("Caelum");
    contato.setEmail("contato@caelum.com.br");
    contato.setEndereco("R. Vergueiro 3185 cj57");
    contato.setDataNascimento(LocalDate.now());

    final DAO bd = new ContatoDAO();
    //bd.add(contato);

    //contato.setId(2L);
    //bd.remove(contato);

    print(bd.get(1));
    for (final Contato c : bd.listAll()) {
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

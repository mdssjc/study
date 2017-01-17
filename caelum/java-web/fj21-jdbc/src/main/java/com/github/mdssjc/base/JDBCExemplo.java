package com.github.mdssjc.base;

import com.github.mdssjc.entity.Contato;
import com.github.mdssjc.jdbc.ContatoDAO;
import com.github.mdssjc.jdbc.DAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class JDBCExemplo {

  private static final String DATE = "dd/MM/yyyy";

  public static void main(String[] args) throws SQLException {
    Contato contato = new Contato();
    // contato.setNome("Caelum");
    // contato.setEmail("contato@caelum.com.br");
    // contato.setEndereco("R. Vergueiro 3185 cj87");
    // contato.setDataNascimento(Calendar.getInstance());

    DAO bd = new ContatoDAO();
    // bd.adiciona(contato);

    contato.setId(2L);
    bd.remove(contato);

    print(bd.get(1));
    for (Contato c : bd.listAll()) {
      print(c);
    }
  }

  private static void print(Contato contato) {
    String dateGet = new SimpleDateFormat(DATE)
        .format(contato.getDataNascimento()
                       .getTime());
    System.out.println("Nome: " + contato.getNome());
    System.out.println("Email: " + contato.getEmail());
    System.out.println("Endereço: " + contato.getEndereco());
    System.out.println("Data de Nascimento: " + dateGet + "\n");
  }
}

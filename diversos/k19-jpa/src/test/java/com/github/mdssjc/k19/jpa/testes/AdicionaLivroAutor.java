package com.github.mdssjc.k19.jpa.testes;

import com.github.mdssjc.k19.jpa.modelo.Autor;
import com.github.mdssjc.k19.jpa.modelo.Livro;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class AdicionaLivroAutor extends JpaEntityManager {

  public static void main(final String[] args) {
    final Autor a = new Autor();
    a.setNome("Rafael Cosentino");

    final Livro l = new Livro();
    l.setNome("JPA2");
    l.getAutores()
     .add(a);

    JpaEntityManager.manager.persist(a);
    JpaEntityManager.manager.persist(l);
  }
}

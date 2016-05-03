package com.github.mdssjc.k19.jpa.testes;

import javax.persistence.EntityManager;

import com.github.com.mdssjc.k19.jpa.testes.util.JpaUtil;
import com.github.mdssjc.k19.jpa.modelo.Autor;
import com.github.mdssjc.k19.jpa.modelo.Livro;

public class AdicionaLivroAutor {

  public static void main(final String[] args) {
    final EntityManager manager = JpaUtil.getEntityManager();

    manager.getTransaction()
           .begin();

    final Autor a = new Autor();
    a.setNome("Rafael Cosentino");

    final Livro l = new Livro();
    l.setNome("JPA2");
    l.getAutores()
     .add(a);

    manager.persist(a);
    manager.persist(l);

    manager.getTransaction()
           .commit();

    manager.close();
  }
}

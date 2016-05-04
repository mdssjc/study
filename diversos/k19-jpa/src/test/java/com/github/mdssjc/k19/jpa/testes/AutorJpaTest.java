package com.github.mdssjc.k19.jpa.testes;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Autor;
import com.github.mdssjc.k19.jpa.modelo.Livro;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class AutorJpaTest extends JpaEntityManager {

  @Test
  public void adicionaAutor() {
    final Autor autor = new Autor();
    autor.setNome("Marcelo");

    JpaEntityManager.manager.persist(autor);

    final Autor resultado = JpaEntityManager.manager.find(Autor.class,
        autor.getId());

    assertEquals(resultado, autor);
  }

  @Test
  public void listaAutores() {
    final Autor autor1 = new Autor();
    autor1.setNome("Marcelo");
    final Autor autor2 = new Autor();
    autor2.setNome("Pedro");

    JpaEntityManager.manager.persist(autor1);
    JpaEntityManager.manager.persist(autor2);
    final Query query = JpaEntityManager.manager.createQuery(
        "SELECT a FROM Autor a");

    final List<Autor> autores = Arrays.asList(autor1, autor2);
    final List<Autor> resultado = query.getResultList();

    assertThat(autores, hasItems(resultado.get(0), resultado.get(1)));
  }

  @Test
  public void adicionaLivroAutor() {
    final Autor autor = new Autor();
    autor.setNome("Rafael Cosentino");

    final Livro livro = new Livro();
    livro.setNome("JPA2");
    livro.getAutores()
         .add(autor);

    JpaEntityManager.manager.persist(autor);
    JpaEntityManager.manager.persist(livro);

    final Livro resultado = JpaEntityManager.manager.find(Livro.class,
        livro.getId());

    assertTrue(resultado.getAutores()
                        .contains(autor));
  }
}

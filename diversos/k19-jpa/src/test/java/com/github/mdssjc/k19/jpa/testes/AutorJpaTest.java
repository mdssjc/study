package com.github.mdssjc.k19.jpa.testes;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Autor;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class AutorJpaTest extends JpaEntityManager {

  @Test
  public void insereAutorComJpa() {
    final Autor autor = new Autor();
    autor.setNome("Marcelo");

    AutorJpaTest.manager.persist(autor);

    final Autor resultado = AutorJpaTest.manager.find(Autor.class,
        autor.getId());
    assertEquals(autor, resultado);
  }

  @Test
  public void listaAutoresComJpa() {
    final Autor autor1 = new Autor();
    autor1.setNome("Marcelo");
    final Autor autor2 = new Autor();
    autor2.setNome("Pedro");

    AutorJpaTest.manager.persist(autor1);
    AutorJpaTest.manager.persist(autor2);
    final Query query = AutorJpaTest.manager.createQuery(
        "SELECT a FROM Autor a");

    final List<Autor> autores = Arrays.asList(autor1, autor2);
    final List<Autor> resultado = query.getResultList();
    assertThat(autores, hasItems(resultado.get(0), resultado.get(1)));
  }
}

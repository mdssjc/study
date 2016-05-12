package com.github.mdssjc.k19.jpa.testes;

import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Query;

import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Editora;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class EditoraJpaTest extends JpaEntityManager {

  @Test
  public void adicionaEditora() {
    final Editora novaEditora = new Editora();
    novaEditora.setNome("Pearson");
    novaEditora.setEmail("contact@pearson.com");

    JpaEntityManager.manager.persist(novaEditora);

    final Editora resultado = JpaEntityManager.manager.find(Editora.class,
        novaEditora.getId());

    assertEquals(resultado, novaEditora);
  }

  @Test
  public void listaEditoras() {
    final Editora novaEditora1 = new Editora();
    novaEditora1.setNome("Pearson");
    novaEditora1.setEmail("contact@pearson.com");

    final Editora novaEditora2 = new Editora();
    novaEditora2.setNome("Novatec");
    novaEditora2.setEmail("contato@novatec.com.br");

    JpaEntityManager.manager.persist(novaEditora1);
    JpaEntityManager.manager.persist(novaEditora2);

    final Query query = JpaEntityManager.manager.createQuery(
        "SELECT e FROM Editora e");
    final List<Editora> editoras = Arrays.asList(novaEditora1, novaEditora2);
    final List<Editora> resultado = query.getResultList();

    assertThat(editoras, hasItems(editoras.get(0), editoras.get(1)));
  }
}

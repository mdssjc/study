package com.github.mdssjc.k19.jpa.testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

import com.github.mdssjc.k19.jpa.modelo.Comentario;
import com.github.mdssjc.k19.jpa.modelo.Topico;
import com.github.mdssjc.k19.jpa.testes.util.JpaEntityManager;

public class TopicoJpaTest extends JpaEntityManager {

  private Topico topico;

  @Before
  public void inicializaTopico() {
    this.topico = new Topico();
    this.topico.setTitulo("K19 - Orphan Removal");

    for (int i = 0; i < 10; i++) {
      final Comentario comentario = new Comentario();
      comentario.setData(Calendar.getInstance());
      this.topico.getComentarios()
                 .add(comentario);
    }
  }

  @Test
  public void adicionaTopicoComentarios() {
    JpaEntityManager.manager.persist(this.topico);

    final Topico resultado = JpaEntityManager.manager.find(Topico.class,
        this.topico.getId());

    assertEquals(this.topico, resultado);
  }

  @Test
  public void testeOrphanRemoval() {
    JpaEntityManager.manager.persist(this.topico);
    final Long id = this.topico.getComentarios()
                               .get(0)
                               .getId();

    final Comentario comentarioAntes = JpaEntityManager.manager.find(
        Comentario.class, id);

    this.topico.getComentarios()
               .clear();
    commit();
    begin();

    final Comentario comentarioDepois = JpaEntityManager.manager.find(
        Comentario.class, id);

    assertEquals(id, comentarioAntes.getId());
    assertNull(comentarioDepois);
  }
}

package com.github.mdssjc.cdc.jpa;

import javax.persistence.EntityManager;

import com.github.mdssjc.cdc.jpa.model.Musica;
import com.github.mdssjc.cdc.jpa.model.MusicaId;
import com.github.mdssjc.cdc.jpa.util.JpaUtil;

public class Main {

  public static void main(final String[] args) {
    final EntityManager entityManager = JpaUtil.getEntityManager();

    try {
      chaveComposta(entityManager);
    } catch (final Exception e) {
      if (entityManager.isOpen()) {
        entityManager.getTransaction()
                     .rollback();
      }
    } finally {
      if (entityManager.isOpen()) {
        entityManager.close();
      }
    }
  }

  private static void chaveComposta(final EntityManager em) {
    em.getTransaction()
      .begin();

    final Musica musica = new Musica(196, "Breathe Into Me");
    em.persist(musica);

    em.getTransaction()
      .commit();

    final int duracaoEmSegundos = 196;
    final String nome = "Breathe Into Me";

    final MusicaId musicaId = new MusicaId(duracaoEmSegundos, nome);
    final Musica musicaSalva = em.find(Musica.class, musicaId);

    System.out.println(musicaSalva.getNome());
  }
}

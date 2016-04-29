package com.github.mdssjc.cdc.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;

import com.github.mdssjc.cdc.jpa.model.CodigoUnico;
import com.github.mdssjc.cdc.jpa.model.Musica;
import com.github.mdssjc.cdc.jpa.model.MusicaId;
import com.github.mdssjc.cdc.jpa.model.Pessoa;
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

    final Pessoa autor = new Pessoa();
    autor.setNome("José");
    autor.setNomeArtistico("Ouro Negro");

    final CodigoUnico codigo = new CodigoUnico();
    codigo.setCodigoUnicoHash("12AA12");
    codigo.setDateRegistro(Calendar.getInstance()
                                   .getTime());

    final Musica musica = new Musica(codigo, autor);
    musica.setDuracaoSegundos(196);
    musica.setNome("Breathe Into Me");

    em.persist(musica);

    em.getTransaction()
      .commit();

    final int idCodigoUnico = musica.getCodigoUnico()
                                    .getId();
    final int idAutor = musica.getAutor()
                              .getId();

    final MusicaId musicaId = new MusicaId(idCodigoUnico, idAutor);
    final Musica musicaSalva = em.find(Musica.class, musicaId);

    System.out.println(musicaSalva.getNome());
  }
}

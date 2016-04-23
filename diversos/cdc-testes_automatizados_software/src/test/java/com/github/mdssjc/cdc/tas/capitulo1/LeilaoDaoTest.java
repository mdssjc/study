package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;

import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LeilaoDaoTest {

  private Session    session;
  private LeilaoDao  leilaoDao;
  private UsuarioDao usuarioDao;

  @Before
  public void antes() {
    this.session = new CriadorDeSessao().getSession();
    this.leilaoDao = new LeilaoDao(this.session);
    this.usuarioDao = new UsuarioDao(this.session);

    this.session.beginTransaction();
  }

  @After
  public void depois() {
    this.session.getTransaction()
                .rollback();
    this.session.close();
  }

  @Test
  public void deveContarLeiloesNaoEncerrados() {
    final Usuario mauricio = new Usuario("Mauricio Aniche",
        "mauricio@aniche.com.br");

    final Leilao ativo = new Leilao("Geladeira", 1500.0, mauricio, false);
    final Leilao encerrado = new Leilao("XBox", 700.0, mauricio, false);
    encerrado.encerra();

    this.usuarioDao.salvar(mauricio);
    this.leilaoDao.salvar(ativo);
    this.leilaoDao.salvar(encerrado);

    final long total = this.leilaoDao.total();

    assertEquals(1L, total);
  }
}

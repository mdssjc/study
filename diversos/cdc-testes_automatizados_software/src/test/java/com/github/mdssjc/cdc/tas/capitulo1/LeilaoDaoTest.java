package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.List;

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

  @Test
  public void deveTrazerLeiloesNaoEncerradosNoPeriodo() {
    // criando as datas
    final Calendar comecoDoIntervalo = Calendar.getInstance();
    comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
    final Calendar fimDoIntervalo = Calendar.getInstance();
    final Calendar dataDoLeilao1 = Calendar.getInstance();
    dataDoLeilao1.add(Calendar.DAY_OF_MONTH, -2);
    final Calendar dataDoLeilao2 = Calendar.getInstance();
    dataDoLeilao2.add(Calendar.DAY_OF_MONTH, -20);

    final Usuario mauricio = new Usuario("Mauricio Aniche",
        "mauricio@aniche.com.br");

    // criando os leilões, cada um com uma data
    final Leilao leilao1 = new Leilao("XBox", 700.0, mauricio, false);
    leilao1.setDataAbertura(dataDoLeilao1);
    final Leilao leilao2 = new Leilao("Geladeira", 1700.0, mauricio, false);
    leilao2.setDataAbertura(dataDoLeilao2);

    // persistindo os objetos no banco
    this.usuarioDao.salvar(mauricio);
    this.leilaoDao.salvar(leilao1);
    this.leilaoDao.salvar(leilao2);

    // invocando o método para testar
    final List<Leilao> leiloes = this.leilaoDao.porPeriodo(comecoDoIntervalo,
        fimDoIntervalo);

    // garantindo que a query funcionou
    assertEquals(1, leiloes.size());
    assertEquals("XBox", leiloes.get(0)
                                .getDescricao());
  }

  @Test
  public void naoDeveTrazerLeiloesEncerradosNoPeriodo() {
    // criando as datas
    final Calendar comecoDoIntervalo = Calendar.getInstance();
    comecoDoIntervalo.add(Calendar.DAY_OF_MONTH, -10);
    final Calendar fimDoIntervalo = Calendar.getInstance();
    final Calendar dataDoLeilao1 = Calendar.getInstance();
    dataDoLeilao1.add(Calendar.DAY_OF_MONTH, -2);

    final Usuario mauricio = new Usuario("Mauricio Aniche",
        "mauricio@aniche.com.br");

    // criando os leilões, cada um com uma data
    final Leilao leilao1 = new Leilao("XBox", 700.0, mauricio, false);
    leilao1.setDataAbertura(dataDoLeilao1);
    leilao1.encerra();

    // persistindo os objetos no banco
    this.usuarioDao.salvar(mauricio);
    this.leilaoDao.salvar(leilao1);

    // invocando o método para testar
    final List<Leilao> leiloes = this.leilaoDao.porPeriodo(comecoDoIntervalo,
        fimDoIntervalo);

    // garantindo que a query funcionou
    assertEquals(0, leiloes.size());
  }
}

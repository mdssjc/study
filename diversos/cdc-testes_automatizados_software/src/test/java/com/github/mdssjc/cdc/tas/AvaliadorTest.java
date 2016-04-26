package com.github.mdssjc.cdc.tas;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class AvaliadorTest {

  private Avaliador leiloeiro;
  private Usuario   joao;
  private Usuario   jose;
  private Usuario   maria;

  @Before
  public void criaAvaliador() {
    this.leiloeiro = new Avaliador();
    this.joao = new Usuario("Joao", "joao@email.com");
    this.jose = new Usuario("José", "jose@email.com");
    this.maria = new Usuario("Maria", "maria@email.com");
  }

  @Test
  public void deveEntenderLancesEmOrdemCrescente() {
    final Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                                               .lance(this.maria, 250.0)
                                               .lance(this.joao, 300.0)
                                               .lance(this.jose, 400.0)
                                               .constroi();

    this.leiloeiro.avalia(leilao);

    assertThat(this.leiloeiro.getMaiorLance(), equalTo(400.0));
    assertThat(this.leiloeiro.getMenorLance(), equalTo(250.0));
  }

  @Test
  public void deveEntenderLeilaoComApenasUmLance() {
    final Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                                               .lance(this.joao, 1000.0)
                                               .constroi();

    this.leiloeiro.avalia(leilao);

    assertThat(this.leiloeiro.getMaiorLance(), equalTo(1000.0));
    assertThat(this.leiloeiro.getMenorLance(), equalTo(1000.0));
  }

  @Test
  public void deveEncontrarOsTresMaioresLances() {
    final Leilao leilao = new CriadorDeLeilao()
                                               .para("Playstation 3 Novo")
                                               .lance(this.joao, 100.0)
                                               .lance(this.maria, 200.0)
                                               .lance(this.joao, 300.0)
                                               .lance(this.maria, 400.0)
                                               .constroi();

    this.leiloeiro.avalia(leilao);

    final List<Lance> maiores = this.leiloeiro.getTresMaiores();

    final Calendar data = Calendar.getInstance();
    assertThat(maiores, hasItems(
        new Lance(data, this.maria, 400.0, leilao),
        new Lance(data, this.joao, 300.0, leilao),
        new Lance(data, this.maria, 200.0, leilao)));
  }

  @Test(expected = RuntimeException.class)
  public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
    final Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                                               .constroi();

    this.leiloeiro.avalia(leilao);
  }
}

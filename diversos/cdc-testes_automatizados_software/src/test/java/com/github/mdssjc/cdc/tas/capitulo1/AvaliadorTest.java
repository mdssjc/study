package com.github.mdssjc.cdc.tas.capitulo1;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

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
    this.joao = new Usuario("Joao");
    this.jose = new Usuario("José");
    this.maria = new Usuario("Maria");
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

    assertThat(maiores.size(), equalTo(3));
    assertThat(maiores.get(0)
                      .getValor(),
        equalTo(400.0));
    assertThat(maiores.get(1)
                      .getValor(),
        equalTo(300.0));
    assertThat(maiores.get(2)
                      .getValor(),
        equalTo(200.0));
  }

  @Test(expected = RuntimeException.class)
  public void naoDeveAvaliarLeiloesSemNenhumLanceDado() {
    final Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                                               .constroi();

    this.leiloeiro.avalia(leilao);
  }
}

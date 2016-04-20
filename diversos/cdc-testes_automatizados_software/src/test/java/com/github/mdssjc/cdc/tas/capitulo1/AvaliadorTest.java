package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;

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

    assertEquals(400, this.leiloeiro.getMaiorLance(), 0.0001);
    assertEquals(250, this.leiloeiro.getMenorLance(), 0.0001);
  }

  @Test
  public void deveEntenderLeilaoComApenasUmLance() {
    final Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                                               .lance(this.joao, 1000.0)
                                               .constroi();

    this.leiloeiro.avalia(leilao);

    assertEquals(1000, this.leiloeiro.getMaiorLance(), 0.0001);
    assertEquals(1000, this.leiloeiro.getMenorLance(), 0.0001);
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

    assertEquals(3, maiores.size());
    assertEquals(400, maiores.get(0)
                             .getValor(),
        0.00001);
    assertEquals(300, maiores.get(1)
                             .getValor(),
        0.00001);
    assertEquals(200, maiores.get(2)
                             .getValor(),
        0.00001);
  }
}

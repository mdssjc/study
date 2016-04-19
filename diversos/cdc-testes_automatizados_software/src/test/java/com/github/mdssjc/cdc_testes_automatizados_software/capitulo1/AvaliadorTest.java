package com.github.mdssjc.cdc_testes_automatizados_software.capitulo1;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class AvaliadorTest {

  @Test
  public void deveEntenderLancesEmOrdemCrescente() {
    final Usuario joao = new Usuario("Joao");
    final Usuario jose = new Usuario("José");
    final Usuario maria = new Usuario("Maria");

    final Leilao leilao = new Leilao("Playstation 3 Novo");

    leilao.propoe(new Lance(maria, 250.0));
    leilao.propoe(new Lance(joao, 300.0));
    leilao.propoe(new Lance(jose, 400.0));

    final Avaliador leiloeiro = new Avaliador();
    leiloeiro.avalia(leilao);

    final double maiorEsperado = 400;
    final double menorEsperado = 250;

    assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
    assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
  }

  @Test
  public void deveEntenderLeilaoComApenasUmLance() {
    final Usuario joao = new Usuario("Joao");

    final Leilao leilao = new Leilao("Playstation 3 Novo");

    leilao.propoe(new Lance(joao, 1000.0));

    final Avaliador leiloeiro = new Avaliador();
    leiloeiro.avalia(leilao);

    assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
    assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
  }

  @Test
  public void deveEncontrarOsTresMaioresLances() {
    final Usuario joao = new Usuario("João");
    final Usuario maria = new Usuario("Maria");

    final Leilao leilao = new Leilao("Playstation 3 Novo");

    leilao.propoe(new Lance(joao, 100.0));
    leilao.propoe(new Lance(maria, 200.0));
    leilao.propoe(new Lance(joao, 300.0));
    leilao.propoe(new Lance(maria, 400.0));

    final Avaliador leiloeiro = new Avaliador();
    leiloeiro.avalia(leilao);

    final List<Lance> maiores = leiloeiro.getTresMaiores();

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

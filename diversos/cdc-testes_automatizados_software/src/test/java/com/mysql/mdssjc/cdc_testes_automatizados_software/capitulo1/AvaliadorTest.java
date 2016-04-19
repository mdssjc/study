package com.mysql.mdssjc.cdc_testes_automatizados_software.capitulo1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AvaliadorTest {

  @Test
  public void deveEntenderLancesEmOrdemCrescente() {
    // cenário: 3 lances em ordem crescente
    final Usuario joao = new Usuario("Joao");
    final Usuario jose = new Usuario("José");
    final Usuario maria = new Usuario("Maria");

    final Leilao leilao = new Leilao("Playstation 3 Novo");

    leilao.propoe(new Lance(maria, 250.0));
    leilao.propoe(new Lance(joao, 300.0));
    leilao.propoe(new Lance(jose, 400.0));

    // executando a ação
    final Avaliador leiloeiro = new Avaliador();
    leiloeiro.avalia(leilao);

    // comparando a saída com o esperado
    final double maiorEsperado = 400;
    final double menorEsperado = 250;

    assertEquals(maiorEsperado, leiloeiro.getMaiorLance(), 0.0001);
    assertEquals(menorEsperado, leiloeiro.getMenorLance(), 0.0001);
  }
}

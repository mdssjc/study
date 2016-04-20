package com.github.mdssjc.cdc_testes_automatizados_software.capitulo1;

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
    leiloeiro = new Avaliador();
    joao = new Usuario("Joao");
    jose = new Usuario("José");
    maria = new Usuario("Maria");
  }

  @Test
  public void deveEntenderLancesEmOrdemCrescente() {
    final Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                                               .lance(maria, 250.0)
                                               .lance(joao, 300.0)
                                               .lance(jose, 400.0)
                                               .constroi();

    leiloeiro.avalia(leilao);

    assertEquals(400, leiloeiro.getMaiorLance(), 0.0001);
    assertEquals(250, leiloeiro.getMenorLance(), 0.0001);
  }

  @Test
  public void deveEntenderLeilaoComApenasUmLance() {
    final Leilao leilao = new CriadorDeLeilao().para("Playstation 3 Novo")
                                               .lance(joao, 1000.0)
                                               .constroi();

    leiloeiro.avalia(leilao);

    assertEquals(1000, leiloeiro.getMaiorLance(), 0.0001);
    assertEquals(1000, leiloeiro.getMenorLance(), 0.0001);
  }

  @Test
  public void deveEncontrarOsTresMaioresLances() {
    final Leilao leilao = new CriadorDeLeilao()
                                               .para("Playstation 3 Novo")
                                               .lance(joao, 100.0)
                                               .lance(maria, 200.0)
                                               .lance(joao, 300.0)
                                               .lance(maria, 400.0)
                                               .constroi();

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

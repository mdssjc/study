package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LeilaoTest {

  @Test
  public void deveReceberUmLance() {
    final Leilao leilao = new Leilao("MacBook Pro 15");

    assertEquals(0, leilao.getLances()
                          .size());

    leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));

    assertEquals(1, leilao.getLances()
                          .size());
    assertEquals(2000, leilao.getLances()
                             .get(0)
                             .getValor(),
        0.00001);
  }

  @Test
  public void deveReceberVariosLances() {
    final Leilao leilao = new Leilao("MacBook Pro 15");
    leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
    leilao.propoe(new Lance(new Usuario("Steve Wozniak"), 3000));

    assertEquals(2, leilao.getLances()
                          .size());
    assertEquals(2000, leilao.getLances()
                             .get(0)
                             .getValor(),
        0.00001);
    assertEquals(3000, leilao.getLances()
                             .get(1)
                             .getValor(),
        0.00001);
  }

  @Test
  public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
    final Leilao leilao = new Leilao("MacBook Pro 15");
    final Usuario steveJobs = new Usuario("Steve Jobs");

    leilao.propoe(new Lance(steveJobs, 2000));
    leilao.propoe(new Lance(steveJobs, 3000));

    assertEquals(1, leilao.getLances()
                          .size());
    assertEquals(2000, leilao.getLances()
                             .get(0)
                             .getValor(),
        0.00001);
  }

  @Test
  public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
    final Leilao leilao = new Leilao("Macbook Pro 15");
    final Usuario steveJobs = new Usuario("Steve Jobs");
    final Usuario billGates = new Usuario("Bill Gates");

    leilao.propoe(new Lance(steveJobs, 2000));
    leilao.propoe(new Lance(billGates, 3000));
    leilao.propoe(new Lance(steveJobs, 4000));
    leilao.propoe(new Lance(billGates, 5000));
    leilao.propoe(new Lance(steveJobs, 6000));
    leilao.propoe(new Lance(billGates, 7000));
    leilao.propoe(new Lance(steveJobs, 8000));
    leilao.propoe(new Lance(billGates, 9000));
    leilao.propoe(new Lance(steveJobs, 10000));
    leilao.propoe(new Lance(billGates, 11000));

    leilao.propoe(new Lance(steveJobs, 12000));

    assertEquals(10, leilao.getLances()
                           .size());
    final int ultimo = leilao.getLances()
                             .size()
        - 1;
    final Lance ultimoLance = leilao.getLances()
                                    .get(ultimo);
    assertEquals(11000.0,
        ultimoLance.getValor(), 0.00001);
  }
}

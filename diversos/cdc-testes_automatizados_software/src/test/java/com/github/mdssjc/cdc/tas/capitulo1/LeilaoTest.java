package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class LeilaoTest {

  private Leilao  leilao;
  private Usuario steveJobs;
  private Usuario steveWozniak;

  @Before
  public void inicializacao() {
    this.leilao = new Leilao();
    this.leilao.setDescricao("MacBook Pro 15");

    this.steveJobs = new Usuario();
    this.steveJobs.setNome("Steve Jobs");

    this.steveWozniak = new Usuario();
    this.steveWozniak.setNome("Steve Wozniak");
  }

  @Test
  public void deveReceberUmLance() {
    assertEquals(0, this.leilao.getLances()
                               .size());

    this.leilao.propoe(new Lance(this.steveJobs, 2000));

    assertEquals(1, this.leilao.getLances()
                               .size());
    assertEquals(2000, this.leilao.getLances()
                                  .get(0)
                                  .getValor(),
        0.00001);
  }

  @Test
  public void deveReceberVariosLances() {
    this.leilao.propoe(new Lance(this.steveJobs, 2000));
    this.leilao.propoe(new Lance(this.steveWozniak, 3000));

    assertEquals(2, this.leilao.getLances()
                               .size());
    assertEquals(2000, this.leilao.getLances()
                                  .get(0)
                                  .getValor(),
        0.00001);
    assertEquals(3000, this.leilao.getLances()
                                  .get(1)
                                  .getValor(),
        0.00001);
  }

  @Test
  public void naoDeveAceitarDoisLancesSeguidosDoMesmoUsuario() {
    this.leilao.propoe(new Lance(this.steveJobs, 2000));
    this.leilao.propoe(new Lance(this.steveJobs, 3000));

    assertEquals(1, this.leilao.getLances()
                               .size());
    assertEquals(2000, this.leilao.getLances()
                                  .get(0)
                                  .getValor(),
        0.00001);
  }

  @Test
  public void naoDeveAceitarMaisDoQue5LancesDeUmMesmoUsuario() {
    final Usuario billGates = new Usuario();
    billGates.setNome("Bill Gates");

    this.leilao.propoe(new Lance(this.steveJobs, 2000));
    this.leilao.propoe(new Lance(billGates, 3000));
    this.leilao.propoe(new Lance(this.steveJobs, 4000));
    this.leilao.propoe(new Lance(billGates, 5000));
    this.leilao.propoe(new Lance(this.steveJobs, 6000));
    this.leilao.propoe(new Lance(billGates, 7000));
    this.leilao.propoe(new Lance(this.steveJobs, 8000));
    this.leilao.propoe(new Lance(billGates, 9000));
    this.leilao.propoe(new Lance(this.steveJobs, 10000));
    this.leilao.propoe(new Lance(billGates, 11000));

    this.leilao.propoe(new Lance(this.steveJobs, 12000));

    assertEquals(10, this.leilao.getLances()
                                .size());
    final int ultimo = this.leilao.getLances()
                                  .size()
        - 1;
    final Lance ultimoLance = this.leilao.getLances()
                                         .get(ultimo);
    assertEquals(11000.0,
        ultimoLance.getValor(), 0.00001);
  }
}

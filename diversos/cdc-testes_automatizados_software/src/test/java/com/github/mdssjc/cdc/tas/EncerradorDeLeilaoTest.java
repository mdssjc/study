package com.github.mdssjc.cdc.tas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;

public class EncerradorDeLeilaoTest {

  private Leilao               leilao1;
  private Leilao               leilao2;
  private EncerradorDeLeilao   encerrador;
  private RepositorioDeLeiloes daoFalso;
  private Carteiro             carteiroFalso;

  @Before
  public void inicializacao() {
    final Calendar antiga = Calendar.getInstance();
    antiga.set(1999, 1, 20);

    this.leilao1 = new CriadorDeLeilao().para("TV de Plasma")
                                        .naData(antiga)
                                        .constroi();
    this.leilao2 = new CriadorDeLeilao().para("Geladeira")
                                        .naData(antiga)
                                        .constroi();

    this.daoFalso = mock(LeilaoDao.class);
    this.carteiroFalso = mock(Carteiro.class);

    this.encerrador = new EncerradorDeLeilao(this.daoFalso,
        this.carteiroFalso);
  }

  @Test
  public void deveEncerrarLeiloesQueComecaramUmaSemanaAtras() {
    when(this.daoFalso.correntes()).thenReturn(
        Arrays.asList(this.leilao1, this.leilao2));

    this.encerrador.encerra();

    assertTrue(this.leilao1.isEncerrado());
    assertTrue(this.leilao2.isEncerrado());
    assertEquals(2, this.encerrador.getTotalEncerrados());
  }

  @Test
  public void deveAtualizarLeiloesEncerrados() {
    when(this.daoFalso.correntes()).thenReturn(Arrays.asList(this.leilao1));

    this.encerrador.encerra();

    verify(this.daoFalso, times(1)).atualiza(this.leilao1);
  }

  @Test
  public void deveContinuarAExecucaoMesmoQuandoDaoFalha() {
    when(this.daoFalso.correntes()).thenReturn(
        Arrays.asList(this.leilao1, this.leilao2));
    doThrow(new RuntimeException()).when(this.daoFalso)
                                   .atualiza(this.leilao1);

    this.encerrador.encerra();

    verify(this.daoFalso).atualiza(this.leilao2);
    verify(this.carteiroFalso).envia(this.leilao2);
  }
}

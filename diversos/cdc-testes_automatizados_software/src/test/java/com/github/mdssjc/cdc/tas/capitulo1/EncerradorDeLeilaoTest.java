package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class EncerradorDeLeilaoTest {

  @Test
  public void deveEncerrarLeiloesQueComecaramUmaSemanaAtras() {
    final Calendar antiga = Calendar.getInstance();
    antiga.set(1999, 1, 20);

    final Leilao leilao1 = new CriadorDeLeilao().para("TV de Plasma")
                                                .naData(antiga)
                                                .constroi();
    final Leilao leilao2 = new CriadorDeLeilao().para("Geladeira")
                                                .naData(antiga)
                                                .constroi();
    final List<Leilao> leiloesAntigos = Arrays.asList(leilao1, leilao2);

    final LeilaoDao daoFalso = mock(LeilaoDao.class);
    Carteiro carteiroFalso = mock(Carteiro.class);
    when(daoFalso.correntes()).thenReturn(leiloesAntigos);

    final EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso,
        carteiroFalso);
    encerrador.encerra();

    assertTrue(leilao1.isEncerrado());
    assertTrue(leilao2.isEncerrado());
    assertEquals(2, encerrador.getTotalEncerrados());
  }

  @Test
  public void deveAtualizarLeiloesEncerrados() {
    final Calendar antiga = Calendar.getInstance();
    antiga.set(1999, 1, 20);

    final Leilao leilao1 = new CriadorDeLeilao().para("TV de Plasma")
                                                .naData(antiga)
                                                .constroi();

    final LeilaoDao daoFalso = mock(LeilaoDao.class);
    Carteiro carteiroFalso = mock(Carteiro.class);
    when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1));

    final EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso,
        carteiroFalso);
    encerrador.encerra();

    verify(daoFalso, times(1)).atualiza(leilao1);
  }

  @Test
  public void deveContinuarAExecucaoMesmoQuandoDaoFalha() {
    Calendar antiga = Calendar.getInstance();
    antiga.set(1999, 1, 20);

    Leilao leilao1 = new CriadorDeLeilao()
                                          .para("TV de plasma")
                                          .naData(antiga)
                                          .constroi();
    Leilao leilao2 = new CriadorDeLeilao()
                                          .para("Geladeira")
                                          .naData(antiga)
                                          .constroi();

    LeilaoDao daoFalso = mock(LeilaoDao.class);
    Carteiro carteiroFalso = mock(Carteiro.class);
    when(daoFalso.correntes()).thenReturn(Arrays.asList(leilao1, leilao2));
    doThrow(new RuntimeException()).when(daoFalso).atualiza(leilao1);

    EncerradorDeLeilao encerrador = new EncerradorDeLeilao(daoFalso,
        carteiroFalso);
    encerrador.encerra();

    verify(daoFalso).atualiza(leilao2);
    verify(carteiroFalso).envia(leilao2);
  }
}

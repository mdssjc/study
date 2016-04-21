package com.github.mdssjc.cdc.tas.capitulo1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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

    final LeilaoDao dao = new LeilaoDao();
    dao.salva(leilao1);
    dao.salva(leilao2);

    final EncerradorDeLeilao encerrador = new EncerradorDeLeilao(dao);
    encerrador.encerra();

    final List<Leilao> encerrados = dao.encerrados();

    assertEquals(2, encerrados.size());
    assertTrue(encerrados.get(0)
                         .isEncerrado());
    assertTrue(encerrados.get(1)
                         .isEncerrado());
  }
}

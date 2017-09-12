package com.github.mdssjc.argentum.modelo;

import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.junit.Assert.assertEquals;

public class CandleBuilderTest {

  @Test
  public void criandoUmCandle() {
    final CandleBuilder builder = new CandleBuilder();

    builder.comAbertura(40.5);
    builder.comFechamento(42.3);
    builder.comMinimo(39.8);
    builder.comMaximo(45.0);
    builder.comVolume(145234.20);
    builder.comData(
        new GregorianCalendar(2012, Calendar.SEPTEMBER, 12,
                              0, 0, 0));

    final Candlestick candle = builder.geraCandle();

    assertEquals(
        "[Abertura 40.5, Fechamento 42.3, Mínima 39.8, Máxima 45.0, Volume 145234.20, Data 12/09/2012]",
        candle.toString());
  }

  @Test(expected = IllegalStateException.class)
  public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
    final CandleBuilder builder = new CandleBuilder();
    builder.geraCandle();
  }
}

package com.github.mdssjc.argentum.modelo;

import org.junit.Test;

import java.util.Calendar;

import static org.junit.Assert.assertEquals;

public class CandlestickTest {

  @Test
  public void formatacaoDosDados() {
    Calendar data = Calendar.getInstance();
    data.set(2008, Calendar.JULY, 12);

    Candlestick candle = new Candlestick(40.5, 42.3, 39.8, 45.0, 145234.20,
                                         data);

    assertEquals(
        "[Abertura 40.5, Fechamento 42.3, Mínima 39.8, Máxima 45.0, Volume 145234.20, Data 12/07/2008]",
        candle.toString());
  }

  @Test(expected = IllegalArgumentException.class)
  public void precoMaximoNaoPodeSerMenorQueMinimo() {
    new Candlestick(10, 20, 20, 10, 10000, Calendar.getInstance());
  }

  @Test(expected = IllegalArgumentException.class)
  public void dataNaoPodeSerNula() {
    new Candlestick(10, 20, 10, 20, 10000, null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void aberturaNaoPodeSerNegativo() {
    new Candlestick(-10, 20, 10, 20, 10000, Calendar.getInstance());
  }

  @Test(expected = IllegalArgumentException.class)
  public void fechamentoNaoPodeSerNegativo() {
    new Candlestick(10, -20, 10, 20, 10000, Calendar.getInstance());
  }

  @Test(expected = IllegalArgumentException.class)
  public void minimoNaoPodeSerNegativo() {
    new Candlestick(10, 20, -10, 20, 10000, Calendar.getInstance());
  }

  @Test(expected = IllegalArgumentException.class)
  public void maximoNaoPodeSerNegativo() {
    new Candlestick(10, 20, 10, -20, 10000, Calendar.getInstance());
  }

  @Test(expected = IllegalArgumentException.class)
  public void volumeNaoPodeSerNegativo() {
    new Candlestick(10, 20, 10, 20, -10000, Calendar.getInstance());
  }

  @Test
  public void quandoAberturaIgualFechamentoEhAlta() {
    Candlestick candle = new Candlestick(10, 10, 10, 20, 10000,
                                         Calendar.getInstance());
    assertEquals(true, candle.isAlta());
    assertEquals(false, candle.isBaixa());
  }
}

package com.github.mdssjc.argentum.testes;

import com.github.mdssjc.argentum.modelo.Candlestick;
import com.github.mdssjc.argentum.modelo.SerieTemporal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class GeradorDeSerie {

  /**
   * Serve para ajudar a fazer os testes.
   * <p>
   * Recebe uma sequência de valores e cria candles com abertura, fechamento,
   * minimo e maximo iguais, mil de volume e data de hoje. Finalmente, devolve
   * tais candles encapsuladas em uma Serie Temporal.
   **/
  public static SerieTemporal criaSerie(final double... valores) {
    final List<Candlestick> candles = new ArrayList<>();
    for (final double d : valores) {
      candles.add(new Candlestick(d, d, d, d, 1000, Calendar.getInstance()));
    }
    return new SerieTemporal(candles);
  }
}

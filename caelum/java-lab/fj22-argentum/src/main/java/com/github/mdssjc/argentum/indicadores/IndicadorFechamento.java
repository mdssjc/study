package com.github.mdssjc.argentum.indicadores;

import com.github.mdssjc.argentum.modelo.SerieTemporal;

public class IndicadorFechamento implements Indicador {

  @Override
  public double calcula(final int posicao, final SerieTemporal serie) {
    return serie.getCandle(posicao)
                .getFechamento();
  }

  @Override
  public String toString() {
    return "Fechamento";
  }
}

package com.github.mdssjc.argentum.indicadores;

import com.github.mdssjc.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {

  private final int intervalo;
  private final Indicador outroIndicador;

  public MediaMovelSimples(final Indicador outroIndicador, final int intervalo) {
    this.outroIndicador = outroIndicador;
    this.intervalo = intervalo;
  }

  @Override
  public double calcula(final int posicao, final SerieTemporal serie) {
    double soma = 0.0;
    for (int i = posicao; i > posicao - this.intervalo; i--) {
      soma += this.outroIndicador.calcula(i, serie);
    }
    return soma / this.intervalo;
  }

  @Override
  public String toString() {
    return "MMS de " + this.outroIndicador;
  }
}

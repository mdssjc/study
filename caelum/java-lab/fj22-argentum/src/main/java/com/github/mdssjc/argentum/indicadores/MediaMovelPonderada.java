package com.github.mdssjc.argentum.indicadores;

import com.github.mdssjc.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

  private final int intervalo;
  private final Indicador outroIndicador;

  public MediaMovelPonderada(final Indicador outroIndicador, final int intervalo) {
    this.outroIndicador = outroIndicador;
    this.intervalo = intervalo;
  }

  @Override
  public double calcula(final int posicao, final SerieTemporal serie) {
    double soma = 0.0;
    int peso = this.intervalo;
    int fatorial = 1;

    for (int i = posicao; i > posicao - this.intervalo; i--) {
      soma += this.outroIndicador.calcula(i, serie) * peso;
      peso--;
    }

    for (int i = 1; i <= this.intervalo; i++) {
      fatorial *= i;
    }

    return soma / fatorial;
  }

  @Override
  public String toString() {
    return "MMP de " + this.outroIndicador;
  }
}

package com.github.mdssjc.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {

  private double abertura;
  private double fechamento;
  private double minimo;
  private double maximo;
  private double volume;
  private Calendar data;
  private final boolean[] flags = new boolean[6];

  public CandleBuilder() {
  }

  public CandleBuilder comAbertura(final double abertura) {
    this.flags[0] = true;
    this.abertura = abertura;
    return this;
  }

  public CandleBuilder comFechamento(final double fechamento) {
    this.flags[1] = true;
    this.fechamento = fechamento;
    return this;
  }

  public CandleBuilder comMinimo(final double minimo) {
    this.flags[2] = true;
    this.minimo = minimo;
    return this;
  }

  public CandleBuilder comMaximo(final double maximo) {
    this.flags[3] = true;
    this.maximo = maximo;
    return this;
  }

  public CandleBuilder comVolume(final double volume) {
    this.flags[4] = true;
    this.volume = volume;
    return this;
  }

  public CandleBuilder comData(final Calendar data) {
    this.flags[5] = true;
    this.data = data;
    return this;
  }

  public Candlestick geraCandle() {
    for (final boolean flag : this.flags) {
      if (!flag) {
        throw new IllegalStateException(
            "Não está chamando a criação de todos os valores.");
      }
    }

    return new Candlestick(this.abertura, this.fechamento, this.minimo,
                           this.maximo, this.volume,
                           this.data);
  }
}

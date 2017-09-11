package com.github.mdssjc.argentum.modelo;

import lombok.Getter;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Locale;

final public class Candlestick {

  @Getter
  private final double abertura;
  @Getter
  private final double fechamento;
  @Getter
  private final double minimo;
  @Getter
  private final double maximo;
  @Getter
  private final double volume;
  @Getter
  private final LocalDateTime data;

  public Candlestick(final double abertura, final double fechamento,
                     final double minimo, final double maximo,
                     final double volume, @NonNull final Calendar data) {
    if (minimo > maximo) {
      throw new IllegalArgumentException(
          "Valor mínimo não pode ser maior que valor máximo.");
    }

    if (abertura < 0 || fechamento < 0 || minimo < 0 || maximo < 0 || volume < 0) {
      throw new IllegalArgumentException(
          "Valor mínimo não pode ser negativo.");
    }

    this.abertura = abertura;
    this.fechamento = fechamento;
    this.minimo = minimo;
    this.maximo = maximo;
    this.volume = volume;
    this.data = LocalDateTime.ofInstant(data.toInstant(),
                                        ZoneId.systemDefault());
  }

  public boolean isAlta() {
    return this.abertura <= this.fechamento;
  }

  public boolean isBaixa() {
    return this.abertura > this.fechamento;
  }

  @Override
  public String toString() {
    return String.format(
        Locale.US,
        "[Abertura %.1f, Fechamento %.1f, Mínima %.1f, Máxima %.1f, Volume %.2f, Data %s]",
        getAbertura(), getFechamento(), getMinimo(), getMaximo(), getVolume(),
        data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
  }
}

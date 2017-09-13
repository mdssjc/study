package com.github.mdssjc.argentum.modelo;

import lombok.Getter;
import lombok.NonNull;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Negociacao implements Serializable {

  private static final long serialVersionUID = 1L;
  @Getter
  private final double preco;
  @Getter
  private final int quantidade;
  private final Calendar data;

  public Negociacao(final double preco, final int quantidade,
                    @NonNull final Calendar data) {
    this.preco = preco;
    this.quantidade = quantidade;
    this.data = data;
  }

  public Calendar getData() {
    return (Calendar) this.data.clone();
  }

  public double getVolume() {
    return this.preco * this.quantidade;
  }

  public boolean isMesmoDia(final Calendar outraData) {
    return this.data.get(Calendar.DAY_OF_MONTH) == outraData
        .get(Calendar.DAY_OF_MONTH)
           && this.data.get(Calendar.MONTH) == outraData
        .get(Calendar.MONTH)
           && this.data.get(Calendar.YEAR) == outraData.get(Calendar.YEAR);
  }

  public String toString() {
    return String.format("Preço: %.2f / Quantidade: %d (%s)", getPreco(),
                         getQuantidade(),
                         new SimpleDateFormat("dd/MM/yyyy").format(
                             getData().getTime()));
  }
}

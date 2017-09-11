package com.github.mdssjc.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class CandlestickFactory {

  public Candlestick constroiCandleParaData(final Calendar data, final List<Negociacao> negociacoes) {
    double maximo = negociacoes.get(0)
                               .getPreco();
    double minimo = negociacoes.get(0)
                               .getPreco();
    double volume = 0;

    for (final Negociacao negociacao : negociacoes) {
      volume += negociacao.getVolume();

      if (negociacao.getPreco() > maximo) {
        maximo = negociacao.getPreco();
      }
      if (negociacao.getPreco() < minimo) {
        minimo = negociacao.getPreco();
      }
    }

    final double abertura = negociacoes.get(0)
                                       .getPreco();
    final double fechamento = negociacoes.get(negociacoes.size() - 1)
                                         .getPreco();

    return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
  }

  public List<Candlestick> constroiCandles(final List<Negociacao> todasNegociacoes) {
    final List<Candlestick> candles = new ArrayList<>();
    todasNegociacoes.sort(Comparator.comparing(Negociacao::getData));

    List<Negociacao> negociacoesDoDia = new ArrayList<>();
    Calendar dataAtual = todasNegociacoes.get(0)
                                         .getData();

    for (final Negociacao negociacao : todasNegociacoes) {
      if (negociacao.getData()
                    .before(dataAtual)) {
        throw new IllegalStateException("negociações em ordem errada");
      }
      // se não for mesmo dia, fecha candle e reinicia variáveis
      if (!negociacao.isMesmoDia(dataAtual)) {
        criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
        negociacoesDoDia = new ArrayList<>();
        dataAtual = negociacao.getData();
      }
      negociacoesDoDia.add(negociacao);
    }
    criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);

    return candles;
  }

  private void criaEGuardaCandle(final List<Candlestick> candles,
                                 final List<Negociacao> negociacoesDoDia, final Calendar dataAtual) {
    final Candlestick candleDoDia = constroiCandleParaData(dataAtual,
                                                           negociacoesDoDia);
    candles.add(candleDoDia);
  }
}

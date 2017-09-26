package com.github.mdssjc.argentum.modelo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class CandlestickFactoryTest {

  private CandlestickFactory fabrica;
  private Calendar hoje;

  @Before
  public void setUp() {
    this.hoje = Calendar.getInstance();
    this.fabrica = new CandlestickFactory();
  }

  @Test
  public void sequenciaSimplesDeNegociacoes() {
    final Negociacao negociacao1 = new Negociacao(40.5, 100, this.hoje);
    final Negociacao negociacao2 = new Negociacao(45.0, 100, this.hoje);
    final Negociacao negociacao3 = new Negociacao(39.8, 100, this.hoje);
    final Negociacao negociacao4 = new Negociacao(42.3, 100, this.hoje);

    final List<Negociacao> negociacoes = Arrays.asList(negociacao1,
                                                       negociacao2,
                                                       negociacao3,
                                                       negociacao4);
    final Candlestick candle = this.fabrica.constroiCandleParaData(this.hoje,
                                                                   negociacoes);

    assertEquals(40.5, candle.getAbertura(), 0.00001);
    assertEquals(42.3, candle.getFechamento(), 0.00001);
    assertEquals(39.8, candle.getMinimo(), 0.00001);
    assertEquals(45.0, candle.getMaximo(), 0.00001);
    assertEquals(16760.0, candle.getVolume(), 0.00001);
  }

  @Test
  public void semNegociacoesGeraCandleComZeros() {
    final List<Negociacao> negociacoes = Collections.emptyList();
    final Candlestick candle = this.fabrica.constroiCandleParaData(this.hoje,
                                                                   negociacoes);

    assertEquals(0.0, candle.getAbertura(), 0.00001);
    assertEquals(0.0, candle.getFechamento(), 0.00001);
    assertEquals(0.0, candle.getMinimo(), 0.00001);
    assertEquals(0.0, candle.getMaximo(), 0.00001);
    assertEquals(0.0, candle.getVolume(), 0.00001);
  }

  @Test
  public void apenasUmaNegociacaoGeraCandleComValoresIguais() {
    final Negociacao negociacao = new Negociacao(40.5, 100, this.hoje);

    final List<Negociacao> negociacoes = Collections.singletonList(negociacao);
    final Candlestick candle = this.fabrica.constroiCandleParaData(this.hoje,
                                                                   negociacoes);

    assertEquals(40.5, candle.getAbertura(), 0.00001);
    assertEquals(40.5, candle.getFechamento(), 0.00001);
    assertEquals(40.5, candle.getMinimo(), 0.00001);
    assertEquals(40.5, candle.getMaximo(), 0.00001);
    assertEquals(4050.0, candle.getVolume(), 0.00001);
  }

  @Test
  public void negociacoesEmOrdemCrescenteDeValor() {
    final Negociacao negociacao1 = new Negociacao(39.8, 100, this.hoje);
    final Negociacao negociacao2 = new Negociacao(40.5, 100, this.hoje);
    final Negociacao negociacao3 = new Negociacao(42.3, 100, this.hoje);
    final Negociacao negociacao4 = new Negociacao(45.0, 100, this.hoje);

    final List<Negociacao> negociacoes = Arrays.asList(negociacao1,
                                                       negociacao2,
                                                       negociacao3,
                                                       negociacao4);
    final Candlestick candle = this.fabrica.constroiCandleParaData(this.hoje,
                                                                   negociacoes);

    assertEquals(39.8, candle.getAbertura(), 0.00001);
    assertEquals(45.0, candle.getFechamento(), 0.00001);
    assertTrue(candle.isAlta());
    assertFalse(candle.isBaixa());
  }

  @Test
  public void negociacoesEmOrdemDecrescenteDeValor() {
    final Negociacao negociacao1 = new Negociacao(45.0, 100, this.hoje);
    final Negociacao negociacao2 = new Negociacao(42.3, 100, this.hoje);
    final Negociacao negociacao3 = new Negociacao(40.5, 100, this.hoje);
    final Negociacao negociacao4 = new Negociacao(39.8, 100, this.hoje);

    final List<Negociacao> negociacoes = Arrays.asList(negociacao1,
                                                       negociacao2,
                                                       negociacao3,
                                                       negociacao4);
    final Candlestick candle = this.fabrica.constroiCandleParaData(this.hoje,
                                                                   negociacoes);

    assertEquals(45.0, candle.getAbertura(), 0.00001);
    assertEquals(39.8, candle.getFechamento(), 0.00001);
    assertFalse(candle.isAlta());
    assertTrue(candle.isBaixa());
  }

  @Test
  public void paraNegociacoesDeTresDiasDistintosGeraTresCandles() {
    final Negociacao negociacao1 = new Negociacao(40.5, 100, this.hoje);
    final Negociacao negociacao2 = new Negociacao(45.0, 100, this.hoje);
    final Negociacao negociacao3 = new Negociacao(39.8, 100, this.hoje);
    final Negociacao negociacao4 = new Negociacao(42.3, 100, this.hoje);

    final Calendar amanha = (Calendar) this.hoje.clone();
    amanha.add(Calendar.DAY_OF_MONTH, 1);

    final Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
    final Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);

    final Calendar depois = (Calendar) amanha.clone();
    depois.add(Calendar.DAY_OF_MONTH, 1);

    final Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
    final Negociacao negociacao8 = new Negociacao(52.3, 100, depois);

    final List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
                                                       negociacao3, negociacao4,
                                                       negociacao5,
                                                       negociacao6, negociacao7,
                                                       negociacao8);

    final CandlestickFactory fabrica = new CandlestickFactory();
    final List<Candlestick> candles = fabrica.constroiCandles(negociacoes);

    assertEquals(3, candles.size());
    assertEquals(40.5, candles.get(0)
                              .getAbertura(), 0.00001);
    assertEquals(42.3, candles.get(0)
                              .getFechamento(), 0.00001);
    assertEquals(48.8, candles.get(1)
                              .getAbertura(), 0.00001);
    assertEquals(49.3, candles.get(1)
                              .getFechamento(), 0.00001);
    assertEquals(51.8, candles.get(2)
                              .getAbertura(), 0.00001);
    assertEquals(52.3, candles.get(2)
                              .getFechamento(), 0.00001);
  }

  @Test(expected = IllegalStateException.class)
  @Ignore("Devido a funcionalidade de ordenação da lista on demand")
  public void naoPermiteConstruirCandlesComNegociacoesForaDeOrdem() {
    final Calendar hoje = Calendar.getInstance();
    final Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);

    final Calendar amanha = (Calendar) hoje.clone();
    amanha.add(Calendar.DAY_OF_MONTH, 1);
    final Negociacao negociacao2 = new Negociacao(48.8, 100, amanha);


    final Calendar depois = (Calendar) amanha.clone();
    depois.add(Calendar.DAY_OF_MONTH, 2);
    final Negociacao negociacao3 = new Negociacao(52.3, 100, depois);

    final List<Negociacao> negociacoes = Arrays.asList(negociacao3, negociacao1,
                                                       negociacao2);

    final CandlestickFactory fabrica = new CandlestickFactory();
    fabrica.constroiCandles(negociacoes);
  }
}

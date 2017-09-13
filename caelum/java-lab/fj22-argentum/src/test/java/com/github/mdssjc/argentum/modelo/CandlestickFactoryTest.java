package com.github.mdssjc.argentum.modelo;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CandlestickFactoryTest {

  private CandlestickFactory fabrica;
  private Calendar hoje;

  @Before
  public void setUp() {
    hoje = Calendar.getInstance();
    fabrica = new CandlestickFactory();
  }

  @Test
  public void sequenciaSimplesDeNegociacoes() {
    Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
    Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
    Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
    Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

    List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
                                                 negociacao3, negociacao4);
    Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

    assertEquals(40.5, candle.getAbertura(), 0.00001);
    assertEquals(42.3, candle.getFechamento(), 0.00001);
    assertEquals(39.8, candle.getMinimo(), 0.00001);
    assertEquals(45.0, candle.getMaximo(), 0.00001);
    assertEquals(16760.0, candle.getVolume(), 0.00001);
  }

  @Test
  public void semNegociacoesGeraCandleComZeros() {
    List<Negociacao> negociacoes = Arrays.asList();
    Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

    assertEquals(0.0, candle.getAbertura(), 0.00001);
    assertEquals(0.0, candle.getFechamento(), 0.00001);
    assertEquals(0.0, candle.getMinimo(), 0.00001);
    assertEquals(0.0, candle.getMaximo(), 0.00001);
    assertEquals(0.0, candle.getVolume(), 0.00001);
  }

  @Test
  public void apenasUmaNegociacaoGeraCandleComValoresIguais() {
    Negociacao negociacao = new Negociacao(40.5, 100, hoje);

    List<Negociacao> negociacoes = Arrays.asList(negociacao);
    Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

    assertEquals(40.5, candle.getAbertura(), 0.00001);
    assertEquals(40.5, candle.getFechamento(), 0.00001);
    assertEquals(40.5, candle.getMinimo(), 0.00001);
    assertEquals(40.5, candle.getMaximo(), 0.00001);
    assertEquals(4050.0, candle.getVolume(), 0.00001);
  }

  @Test
  public void negociacoesEmOrdemCrescenteDeValor() {
    Negociacao negociacao1 = new Negociacao(39.8, 100, hoje);
    Negociacao negociacao2 = new Negociacao(40.5, 100, hoje);
    Negociacao negociacao3 = new Negociacao(42.3, 100, hoje);
    Negociacao negociacao4 = new Negociacao(45.0, 100, hoje);

    List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
                                                 negociacao3, negociacao4);
    Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

    assertEquals(39.8, candle.getAbertura(), 0.00001);
    assertEquals(45.0, candle.getFechamento(), 0.00001);
    assertEquals(true, candle.isAlta());
    assertEquals(false, candle.isBaixa());
  }

  @Test
  public void negociacoesEmOrdemDecrescenteDeValor() {
    Negociacao negociacao1 = new Negociacao(45.0, 100, hoje);
    Negociacao negociacao2 = new Negociacao(42.3, 100, hoje);
    Negociacao negociacao3 = new Negociacao(40.5, 100, hoje);
    Negociacao negociacao4 = new Negociacao(39.8, 100, hoje);

    List<Negociacao> negociacoes = Arrays.asList(negociacao1, negociacao2,
                                                 negociacao3, negociacao4);
    Candlestick candle = fabrica.constroiCandleParaData(hoje, negociacoes);

    assertEquals(45.0, candle.getAbertura(), 0.00001);
    assertEquals(39.8, candle.getFechamento(), 0.00001);
    assertEquals(false, candle.isAlta());
    assertEquals(true, candle.isBaixa());
  }
}

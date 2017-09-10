package com.github.mdssjc.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import com.github.mdssjc.argentum.modelo.Candle;
import com.github.mdssjc.argentum.modelo.CandleFactory;
import com.github.mdssjc.argentum.modelo.Negociacao;

public class TestaCandlestickFactorySemNegociacoes {
    public static void main(String[] args) {
        Calendar hoje = Calendar.getInstance();

        List<Negociacao> negociacoes = Arrays.asList();

        CandleFactory fabrica = new CandleFactory();
        Candle candle = fabrica.constroiCandleParaData(hoje, negociacoes);

        System.out.println(candle.getAbertura());
        System.out.println(candle.getFechamento());
        System.out.println(candle.getMinimo());
        System.out.println(candle.getMaximo());
        System.out.println(candle.getVolume());
    }
}

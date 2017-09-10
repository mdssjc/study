package com.github.mdssjc.argentum.testes;

import java.util.GregorianCalendar;

import com.github.mdssjc.argentum.modelo.CandleBuilder;
import com.github.mdssjc.argentum.modelo.Candle;

public class TestaCandleBuilder {
    public static void main(String[] args) {
        Candle candle = new CandleBuilder()
                .comAbertura(40.5)
                .comFechamento(42.3)
                .comMinimo(39.8)
                .comMaximo(45.0)
                .comVolume(145234.20)
                .comData(new GregorianCalendar(2008, 8, 12, 0, 0, 0))
                .geraCandle();

        System.out.println(candle);
    }
}

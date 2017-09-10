package com.github.mdssjc.argentum.modelo;

import java.util.Calendar;

public class CandleBuilder {
    private double    abertura;
    private double    fechamento;
    private double    minimo;
    private double    maximo;
    private double    volume;
    private Calendar  data;
    private boolean[] flags = new boolean[6];

    public CandleBuilder() {
    }

    public CandleBuilder comAbertura(double abertura) {
        flags[0] = true;
        this.abertura = abertura;
        return this;
    }

    public CandleBuilder comFechamento(double fechamento) {
        flags[1] = true;
        this.fechamento = fechamento;
        return this;
    }

    public CandleBuilder comMinimo(double minimo) {
        flags[2] = true;
        this.minimo = minimo;
        return this;
    }

    public CandleBuilder comMaximo(double maximo) {
        flags[3] = true;
        this.maximo = maximo;
        return this;
    }

    public CandleBuilder comVolume(double volume) {
        flags[4] = true;
        this.volume = volume;
        return this;
    }

    public CandleBuilder comData(Calendar data) {
        flags[5] = true;
        this.data = data;
        return this;
    }

    public Candle geraCandle() {
        for (boolean flag : flags) {
            if (!flag) {
                throw new IllegalStateException("Não está chamando a criacação de todos os valores.");
            }
        }

        return new Candle(abertura, fechamento, minimo, maximo, volume, data);
    }
}

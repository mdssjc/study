package com.github.mdssjc.argentum.modelo;

import java.util.List;
import java.util.Optional;

public class SerieTemporal {

    private final List<Candle> candles;

    public SerieTemporal(List<Candle> candles) {
        this.candles = Optional.ofNullable(candles)
                               .orElseThrow(() -> new IllegalArgumentException(
                                       "a lista de candles não pode ser nula."));
    }

    public Candle getCandle(int i) {
        return this.candles.get(i);
    }

    public int getUltimaPosicao() {
        return this.candles.size() - 1;
    }
}

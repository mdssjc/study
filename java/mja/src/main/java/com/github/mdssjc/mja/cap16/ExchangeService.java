package com.github.mdssjc.mja.cap16;

import static com.github.mdssjc.mja.cap16.Utils.delay;

public class ExchangeService {

    public static final double DEFAULT_RATE = 1D;

    public enum Money {
        USD(1.0), EUR(1.5);

        private final double rate;

        Money(double rate) {
            this.rate = rate;
        }
    }

    public static double getRate(Money source, Money destination) {
        return getRateWithDelay(source, destination);
    }

    private static double getRateWithDelay(Money source, Money destination) {
        delay();
        return destination.rate / source.rate;
    }
}

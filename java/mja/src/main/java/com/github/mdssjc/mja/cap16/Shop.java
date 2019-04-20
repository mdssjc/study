package com.github.mdssjc.mja.cap16;

import lombok.Getter;

import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

import static com.github.mdssjc.mja.cap16.Utils.delay;
import static com.github.mdssjc.mja.cap16.Utils.randomDelay;

public class Shop {

    @Getter
    private String name;
    private Random random;

    public Shop(String name) {
        this.name = name;
        this.random = new Random();
    }

    public String getPrice(String product) {
        double price = getPriceRaw(product);
        Discount.Code[] codes = Discount.Code.values();
        Discount.Code code = codes[this.random.nextInt(codes.length)];
        return String.format(Locale.ENGLISH, "%s:%,.2f:%s", this.name, price, code);
    }

    public String getPriceEx(String product) {
        randomDelay();
        double price = calculatePrice(product);
        Discount.Code[] codes = Discount.Code.values();
        Discount.Code code = codes[this.random.nextInt(codes.length)];
        return String.format(Locale.ENGLISH, "%s:%,.2f:%s", this.name, price, code);
    }

    public double getPriceRaw(String product) {
        delay();
        return calculatePrice(product);
    }

    public Future<Double> getPriceAsync(String product) {
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    private double calculatePrice(String product) {
        return this.random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}

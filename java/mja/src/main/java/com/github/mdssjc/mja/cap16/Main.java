package com.github.mdssjc.mja.cap16;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());

        Finder find = new Finder();
        exec(find::findPricesV1);
        exec(find::findPricesV2);
        exec(find::findPricesV3);
        exec(find::findPricesV4);
        exec(find::findPricesV5);
        exec(find::findPricesV6);

        long start = System.nanoTime();
        CompletableFuture[] futures = find.findPricesV7("myPhone27S")
                                          .map(f -> f.thenAccept(
                                                  s -> System.out.println(s + " (done in " + ((System.nanoTime() - start) / 1_000_000) + " msecs")))
                                          .toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
        System.out.println("All shops have now responded in " + ((System.nanoTime() - start) / 1_000_000) + " msecs");
    }

    private static void exec(Function<String, List<String>> fn) {
        long start = System.nanoTime();
        System.out.println(fn.apply("myPhone27S"));
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Done in " + duration + " msecs");
    }

    private static void exp01() {
        Shop shop = new Shop("BestShop");
        long start = System.nanoTime();
        Future<Double> futurePrice = shop.getPriceAsync("my favorite product");
        long invocationTime = (System.nanoTime() - start) / 1_000_000;
        System.out.println("Invocation returned after " + invocationTime + " msecs");

        // Do some more tasks, like querying other shops
        doSomethingElse();
        // while the price of the product is being calculated
        try {
            double price = futurePrice.get();
            System.out.printf("Price is %.2f%n", price);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        long retrievalTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("Price returned after " + retrievalTime + " msecs");
    }

    private static void doSomethingElse() {
        System.out.println("doing something else...");
    }
}

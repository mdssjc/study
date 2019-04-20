package com.github.mdssjc.mja.cap16;

import com.github.mdssjc.mja.cap16.ExchangeService.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static com.github.mdssjc.mja.cap16.ExchangeService.DEFAULT_RATE;
import static java.util.stream.Collectors.toList;

public class Finder {

    private List<Shop> shops;
    private final ExecutorService executor;

    public Finder() {
        this.shops = List.of(
                new Shop("BestShop"),
                new Shop("BestPrice"),
                new Shop("LetsSaveBig"),
                new Shop("MyFavoriteShop"),
                new Shop("BuyItAll"));

        this.executor = Executors.newFixedThreadPool(Math.min(this.shops.size(), 100), r -> {
            Thread t = new Thread(r);
            t.setDaemon(true);
            return t;
        });
    }

    public List<String> findPricesV1(String product) {
        return this.shops.stream()
                         .map(shop -> getFormat(product, shop))
                         .collect(toList());
    }

    public List<String> findPricesV2(String product) {
        return this.shops.parallelStream()
                         .map(shop -> getFormat(product, shop))
                         .collect(toList());
    }

    public List<String> findPricesV3(String product) {
        List<CompletableFuture<String>> priceFutures =
                this.shops.stream()
                          .map(shop -> CompletableFuture.supplyAsync(
                                  () -> getFormat(product, shop),
                                  this.executor))
                          .collect(toList());
        return priceFutures.stream()
                           .map(CompletableFuture::join)
                           .collect(toList());

    }

    public List<String> findPricesV4(String product) {
        return this.shops.stream()
                         .map(shop -> shop.getPrice(product))
                         .map(Quote::parse)
                         .map(Discount::applyDiscount)
                         .collect(toList());
    }

    public List<String> findPricesV5(String product) {
        List<CompletableFuture<String>> priceFutures =
                this.shops.stream()
                          .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), this.executor))
                          .map(future -> future.thenApply(Quote::parse))
                          .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), this.executor)))
                          .collect(toList());

        return priceFutures.stream()
                           .map(CompletableFuture::join)
                           .collect(toList());
    }

    public List<String> findPricesV6(String product) {
        List<CompletableFuture<Double>> priceFutures = new ArrayList<>();

        this.shops.forEach(
                shop -> priceFutures.add(
                        CompletableFuture.supplyAsync(() -> shop.getPriceRaw(product))
                                         .thenCombine(CompletableFuture.supplyAsync(
                                                 () -> ExchangeService.getRate(Money.EUR, Money.USD))
                                                                       .completeOnTimeout(DEFAULT_RATE, 1, TimeUnit.SECONDS),
                                                 (price, rate) -> price * rate)
                                         .orTimeout(3, TimeUnit.SECONDS)));

        return priceFutures.stream()
                           .map(CompletableFuture::join)
                           .map(String::valueOf)
                           .collect(toList());
    }

    public Stream<CompletableFuture<String>> findPricesV7(String product) {
        return this.shops.stream()
                         .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPriceEx(product), this.executor))
                         .map(future -> future.thenApply(Quote::parse))
                         .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote), this.executor)));
    }

    private String getFormat(String product, Shop shop) {
        return String.format("%s price is %s", shop.getName(), shop.getPrice(product));
    }
}

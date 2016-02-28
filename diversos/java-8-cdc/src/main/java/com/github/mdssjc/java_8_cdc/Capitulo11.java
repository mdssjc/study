package com.github.mdssjc.java_8_cdc;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.mdssjc.java_8_cdc.capitulo11.Customer;
import com.github.mdssjc.java_8_cdc.capitulo11.Payment;
import com.github.mdssjc.java_8_cdc.capitulo11.Product;

public class Capitulo11 {

  public static void main(final String[] args) {
    // Populando o Sistema
    final Customer paulo = new Customer("Paulo Silveira");
    final Customer rodrigo = new Customer("Rodrigo Turini");
    final Customer guilherme = new Customer("Guilherme Silveira");
    final Customer adriano = new Customer("Adriano Almeida");

    final Product bach = new Product("Bach Completo",
        Paths.get("/music/bach.mp3"), new BigDecimal(100));
    final Product poderosas = new Product("Poderosas Anita",
        Paths.get("/music/poderosas.mp3"), new BigDecimal(90));
    final Product bandeira = new Product("Bandeira Brasil",
        Paths.get("/images/brasil.jpg"), new BigDecimal(50));
    final Product beauty = new Product("Beleza Americana",
        Paths.get("beauty.mov"), new BigDecimal(150));
    final Product vingadores = new Product("Os Vingadores",
        Paths.get("/movies/vingadores.mov"), new BigDecimal(200));
    final Product amelie = new Product("Amelie Poulain",
        Paths.get("/movies/amelie.mov"), new BigDecimal(100));

    final LocalDateTime today = LocalDateTime.now();
    final LocalDateTime yesterday = today.minusDays(1);
    final LocalDateTime lastMonth = today.minusMonths(1);

    final Payment payment1 = new Payment(Arrays.asList(bach, poderosas), today,
        paulo);
    final Payment payment2 = new Payment(Arrays.asList(bach, bandeira, amelie),
        yesterday, rodrigo);
    final Payment payment3 = new Payment(
        Arrays.asList(beauty, vingadores, bach), today, adriano);
    final Payment payment4 = new Payment(Arrays.asList(bach, poderosas, amelie),
        lastMonth, guilherme);
    final Payment payment5 = new Payment(Arrays.asList(beauty, amelie),
        yesterday, paulo);

    final List<Payment> payments = Arrays.asList(payment1, payment2, payment3,
        payment4, payment5);

    // Ordenando
    payments.stream()
            .sorted(Comparator.comparing(Payment::getDate))
            .forEach(System.out::println);

    // Redução
    payment1.getProducts()
            .stream()
            .map(Product::getPrice)
            .reduce(BigDecimal::add)
            .ifPresent(System.out::println);

    final Function<Payment, Stream<BigDecimal>> mapper = p -> p.getProducts()
                                                               .stream()
                                                               .map(
                                                                   Product::getPrice);

    final BigDecimal total = payments.stream()
                                     .flatMap(mapper)
                                     .reduce(BigDecimal.ZERO, BigDecimal::add);
    System.out.println("Total: " + total);

    // Contagem
    final Stream<Product> products = payments.stream()
                                             .flatMap(p -> p.getProducts()
                                                            .stream());

    final Map<Product, Long> topProducts = products.collect(
        Collectors.groupingBy(Function.identity(), Collectors.counting()));

    topProducts.entrySet()
               .stream()
               .max(Comparator.comparing(Map.Entry::getValue))
               .ifPresent(System.out::println);
  }
}

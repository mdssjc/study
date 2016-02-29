package com.github.mdssjc.java_8_cdc;

import java.math.BigDecimal;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.github.mdssjc.java_8_cdc.capitulo11.Customer;
import com.github.mdssjc.java_8_cdc.capitulo11.Payment;
import com.github.mdssjc.java_8_cdc.capitulo11.Product;
import com.github.mdssjc.java_8_cdc.capitulo11.Subscription;

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
    final Map<Product, Long> topProducts;
    topProducts = payments.stream()
                          .flatMap(p -> p.getProducts()
                                         .stream())
                          .collect(
                              Collectors.groupingBy(
                                  Function.identity(),
                                  Collectors.counting()));

    topProducts.entrySet()
               .stream()
               .max(Comparator.comparing(Map.Entry::getValue))
               .ifPresent(System.out::println);

    // Sumarização
    final Map<Product, BigDecimal> totalValuePerProduct;
    totalValuePerProduct = payments.stream()
                                   .flatMap(
                                       p -> p.getProducts()
                                             .stream())
                                   .collect(
                                       Collectors.groupingBy(
                                           Function.identity(),
                                           Collectors.reducing(
                                               BigDecimal.ZERO,
                                               Product::getPrice,
                                               BigDecimal::add)));

    totalValuePerProduct.entrySet()
                        .stream()
                        .sorted(Comparator.comparing(Map.Entry::getValue))
                        .forEach(System.out::println);

    final BinaryOperator<List<Product>> binaryOperator = (l1, l2) -> {
      final List<Product> list = new ArrayList<>();
      list.addAll(l1);
      list.addAll(l2);
      return list;
    };
    Map<Customer, List<Product>> customerToProducts;

    customerToProducts = payments.stream()
                                 .collect(
                                     Collectors.groupingBy(Payment::getCustomer,
                                         Collectors.reducing(
                                             Collections.emptyList(),
                                             Payment::getProducts,
                                             binaryOperator)));

    customerToProducts.entrySet()
                      .stream()
                      .sorted(Comparator.comparing(e -> e.getKey()
                                                         .getName()))
                      .forEach(System.out::println);

    final Function<Payment, BigDecimal> paymentToTotal = p -> p.getProducts()
                                                               .stream()
                                                               .map(
                                                                   Product::getPrice)
                                                               .reduce(
                                                                   BigDecimal.ZERO,
                                                                   BigDecimal::add);

    Map<Customer, BigDecimal> totalValuePerCustomer;
    totalValuePerCustomer = payments.stream()
                                    .collect(
                                        Collectors.groupingBy(
                                            Payment::getCustomer,
                                            Collectors.reducing(
                                                BigDecimal.ZERO,
                                                paymentToTotal,
                                                BigDecimal::add)));

    totalValuePerCustomer.entrySet()
                         .stream()
                         .sorted(Comparator.comparing(Map.Entry::getValue))
                         .forEach(System.out::println);

    // Datas
    Map<YearMonth, List<Payment>> paymentsPerMonth;
    paymentsPerMonth = payments.stream()
                               .collect(Collectors.groupingBy(
                                   p -> YearMonth.from(p.getDate())));

    paymentsPerMonth.entrySet()
                    .stream()
                    .forEach(System.out::println);

    Map<YearMonth, BigDecimal> paymentsValuePerMonth;
    paymentsValuePerMonth = payments.stream()
                                    .collect(Collectors.groupingBy(
                                        p -> YearMonth.from(p.getDate()),
                                        Collectors.reducing(BigDecimal.ZERO,
                                            p -> p.getProducts()
                                                  .stream()
                                                  .map(
                                                      Product::getPrice)
                                                  .reduce(
                                                      BigDecimal.ZERO,
                                                      BigDecimal::add),
                                            BigDecimal::add)));

    paymentsValuePerMonth.entrySet()
                         .stream()
                         .forEach(System.out::println);

    // Assinaturas
    final BigDecimal monthlyFee = new BigDecimal("99.90");

    final Subscription s1 = new Subscription(monthlyFee,
        yesterday.minusMonths(5),
        paulo);
    final Subscription s2 = new Subscription(monthlyFee,
        yesterday.minusMonths(8),
        today.minusMonths(1),
        rodrigo);
    final Subscription s3 = new Subscription(monthlyFee,
        yesterday.minusMonths(5),
        today.minusMonths(2), rodrigo);

    final List<Subscription> subscriptions = Arrays.asList(s1, s2, s3);

    final BigDecimal totalS1 = s1.getTotalPaid();
    System.out.println(totalS1);

    final BigDecimal totalPaid = subscriptions.stream()
                                              .map(Subscription::getTotalPaid)
                                              .reduce(BigDecimal.ZERO,
                                                  BigDecimal::add);
    System.out.println(totalPaid);
  }
}

package com.github.mdssjc.fpij;

import static com.github.mdssjc.fpij.Prices.prices;

import java.math.BigDecimal;

public class DiscountFunctional {

  public static void main(final String[] args) {
    final BigDecimal totalOfDiscountedPrices;
    totalOfDiscountedPrices = prices.stream()
                                    .filter(price -> price.compareTo(
                                        BigDecimal.valueOf(20)) > 0)
                                    .map(price -> price.multiply(
                                        BigDecimal.valueOf(0.9)))
                                    .reduce(BigDecimal.ZERO, BigDecimal::add);

    System.out.println(
        "Total of discounted prices: " + totalOfDiscountedPrices);
  }
}

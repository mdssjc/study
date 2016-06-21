package com.github.mdssjc.fpij;

import static com.github.mdssjc.fpij.Prices.prices;

import java.math.BigDecimal;

public class DiscountImperative {

  public static void main(final String[] args) {
    BigDecimal totalOfDiscountedPrices = BigDecimal.ZERO;

    for (final BigDecimal price : prices) {
      if (price.compareTo(BigDecimal.valueOf(20)) > 0) {
        totalOfDiscountedPrices = totalOfDiscountedPrices.add(
            price.multiply(BigDecimal.valueOf(0.9)));
      }
    }
    System.out.println(
        "Total of discounted prices: " + totalOfDiscountedPrices);
  }
}

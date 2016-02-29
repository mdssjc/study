package com.github.mdssjc.java_8_cdc.capitulo11;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Optional;

public class Subscription {

  private final BigDecimal              monthlyFee;
  private final LocalDateTime           begin;
  private final Optional<LocalDateTime> end;
  private final Customer                customer;

  public Subscription(final BigDecimal monthlyFee, final LocalDateTime begin,
      final Customer customer) {
    this.monthlyFee = monthlyFee;
    this.begin = begin;
    this.end = Optional.empty();
    this.customer = customer;
  }

  public Subscription(final BigDecimal monthlyFee, final LocalDateTime begin,
      final LocalDateTime end, final Customer customer) {
    this.monthlyFee = monthlyFee;
    this.begin = begin;
    this.end = Optional.of(end);
    this.customer = customer;
  }

  public BigDecimal getMonthlyFee() {
    return this.monthlyFee;
  }

  public LocalDateTime getBegin() {
    return this.begin;
  }

  public Optional<LocalDateTime> getEnd() {
    return this.end;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  public BigDecimal getTotalPaid() {
    return getMonthlyFee()
                          .multiply(new BigDecimal(ChronoUnit.MONTHS
                                                                    .between(
                                                                        getBegin(),
                                                                        getEnd().orElse(
                                                                            LocalDateTime.now()))));
  }
}

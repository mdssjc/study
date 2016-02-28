package com.github.mdssjc.java_8_cdc.capitulo11;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Payment {

  private final List<Product> products;
  private final LocalDateTime date;
  private final Customer      customer;

  public Payment(final List<Product> products,
      final LocalDateTime date,
      final Customer customer) {
    this.products = products;
    this.date = date;
    this.customer = customer;
  }

  public List<Product> getProducts() {
    return this.products;
  }

  public LocalDateTime getDate() {
    return this.date;
  }

  public Customer getCustomer() {
    return this.customer;
  }

  @Override
  public String toString() {
    return "[Payment: "
        + this.date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        + " " + this.customer + " " + this.products + "]";
  }
}

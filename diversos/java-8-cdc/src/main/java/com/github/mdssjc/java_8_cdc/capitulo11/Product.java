package com.github.mdssjc.java_8_cdc.capitulo11;

import java.math.BigDecimal;
import java.nio.file.Path;

public class Product {

  private final String     name;
  private final Path       file;
  private final BigDecimal price;

  public Product(final String name, final Path file, final BigDecimal price) {
    this.name = name;
    this.file = file;
    this.price = price;
  }

  public String getName() {
    return this.name;
  }

  public Path getFile() {
    return this.file;
  }

  public BigDecimal getPrice() {
    return this.price;
  }

  @Override
  public String toString() {
    return this.name;
  }
}

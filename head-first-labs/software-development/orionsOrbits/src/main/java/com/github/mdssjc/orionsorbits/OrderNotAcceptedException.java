package com.github.mdssjc.orionsorbits;

public class OrderNotAcceptedException extends Exception {

  private final Order order;

  public OrderNotAcceptedException(final Order order) {
    this.order = order;
  }
}

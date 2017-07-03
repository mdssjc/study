package com.github.mdssjc.simuduck;

import java.util.Random;

public class DuckAdapter implements Turkey {

  private final Duck duck;
  private final Random rand;

  public DuckAdapter(final Duck duck) {
    this.duck = duck;
    this.rand = new Random();
  }

  public void gobble() {
    this.duck.performQuack();
  }

  public void fly() {
    if (this.rand.nextInt(5) == 0) {
      this.duck.performFly();
    }
  }
}

package com.github.mdssjc.chocolate;

public class ChocolateBoiler {

  private volatile static ChocolateBoiler instance;
  private boolean empty;
  private boolean boiled;

  private ChocolateBoiler() {
    this.empty = true;
    this.boiled = false;
  }

  public static ChocolateBoiler getInstance() {
    if (instance == null) {
      synchronized (ChocolateBoiler.class) {
        if (instance == null) {
          instance = new ChocolateBoiler();
        }
      }
    }
    return instance;
  }

  public void fill() {
    if (isEmpty()) {
      this.empty = false;
      this.boiled = false;
      // fill the boiler with a milk/chocolate mixture
    }
  }

  public void drain() {
    if (!isEmpty() && isBoiled()) {
      // drain the boiled milk and chocolate
      this.empty = true;
    }
  }

  public void boil() {
    if (!isEmpty() && !isBoiled()) {
      // bring the contents to a boil
      this.boiled = true;
    }
  }

  public boolean isEmpty() {
    return this.empty;
  }

  public boolean isBoiled() {
    return this.boiled;
  }
}

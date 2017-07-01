package com.github.mdssjc.simuduck;

public class TurkeyAdapter extends Duck {

  private final Turkey turkey;

  public TurkeyAdapter(final Turkey turkey) {
    this.turkey = turkey;
  }

  public void performFly() {
    for (int i = 0; i < 5; i++) {
      this.turkey.fly();
    }
  }

  public void performQuack() {
    this.turkey.gobble();
  }

  @Override
  public void display() {
    System.out.println("I'm a turkey");
  }
}

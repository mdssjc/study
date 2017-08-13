package com.github.mdssjc.appendixii;

public class FlyTest3 {

  public static void main(final String[] args) {
    final Jet2 jet1 = new Jet2();
    jet1.speed = 212;
    System.out.println(jet1.speed);

    final Jet2 jet2 = new Jet2();
    jet2.setSpeed(212);
    System.out.println(jet2.getSpeed());
  }
}

package com.github.mdssjc.hfl.ooad;

public class Jet2 extends Airplane2 {

  private static final int MULTIPLIER = 2;

  @Override
  public void setSpeed(final int speed) {
    super.setSpeed(speed * Jet2.MULTIPLIER);
  }

  public void accelerate() {
    super.setSpeed(getSpeed() * 2);
  }
}

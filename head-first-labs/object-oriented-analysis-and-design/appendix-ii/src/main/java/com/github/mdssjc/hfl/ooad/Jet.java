package com.github.mdssjc.hfl.ooad;

public class Jet extends Airplane {

  private static final int MULTIPLIER = 2;

  @Override
  public void setSpeed(final int speed) {
    super.setSpeed(speed * Jet.MULTIPLIER);
  }

  public void accelerate() {
    super.setSpeed(getSpeed() * 2);
  }
}

package com.github.mdssjc.simuduck;

public class GooseAdapter implements Quackable {

  private Goose goose;

  public GooseAdapter(final Goose goose) {
    this.goose = goose;
  }

  @Override
  public void quack() {
    goose.honk();
  }
}

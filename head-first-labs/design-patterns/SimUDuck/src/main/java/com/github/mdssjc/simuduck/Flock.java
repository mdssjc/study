package com.github.mdssjc.simuduck;

import java.util.ArrayList;
import java.util.List;

public class Flock implements Quackable {

  private final List<Quackable> quackers;

  public Flock() {
    this.quackers = new ArrayList<>();
  }

  public void add(final Quackable quacker) {
    this.quackers.add(quacker);
  }

  @Override
  public void quack() {
    for (final Quackable quacker : this.quackers) {
      quacker.quack();
    }
  }
}

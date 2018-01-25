package com.github.mdssjc.design_patterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * Flyweight Factory.
 *
 * @author Marcelo dos Santos
 *
 */
public class FlyweightFactory {

  private final Map<String, Flyweight> flyweights;

  public FlyweightFactory() {
    this.flyweights = new HashMap<>();
  }


  public Flyweight getFlyweight(final String key) {
    if (this.flyweights.containsKey(key)) {
      return this.flyweights.get(key);
    }

    if ("concrete".equals(key)) {
      final Flyweight concrete = new ConcreteFlyweight(" | ");
      this.flyweights.put(key, concrete);
      return concrete;
    } else {
      return new UnsharedConcreteFlyweight();
    }
  }
}

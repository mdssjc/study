package com.github.mdssjc.starbuzz;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StarbuzzCoffeeTest {

  @Test
  public void espressoTest() {
    final Beverage beverage = new Espresso();

    final String description = beverage.getDescription();
    final double cost = beverage.cost();

    assertEquals("Espresso", description);
    assertEquals(1.99, cost, 0.01);
  }

  @Test
  public void darkRoastTest() {
    Beverage beverage = new DarkRoast();
    beverage = new Mocha(beverage);
    beverage = new Mocha(beverage);
    beverage = new Whip(beverage);

    final String description = beverage.getDescription();
    final double cost = beverage.cost();

    assertEquals("Dark Roast Coffee, Mocha, Mocha, Whip", description);
    assertEquals(1.49, cost, 0.01);
  }

  @Test
  public void houseBlendTest() {
    Beverage beverage = new HouseBlend();
    beverage = new Soy(beverage);
    beverage = new Mocha(beverage);
    beverage = new Whip(beverage);

    final String description = beverage.getDescription();
    final double cost = beverage.cost();

    assertEquals("House Blend Coffee, Soy, Mocha, Whip", description);
    assertEquals(1.34, cost, 0.01);
  }
}

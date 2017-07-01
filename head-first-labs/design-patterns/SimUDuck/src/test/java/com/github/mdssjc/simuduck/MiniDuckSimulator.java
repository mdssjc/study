package com.github.mdssjc.simuduck;

import com.github.mdssjc.simuduck.fly.FlyRocketPowered;

public class MiniDuckSimulator {

  public static void main(final String[] args) {
    final Duck mallard = new MallardDuck();
    mallard.performQuack();
    mallard.performFly();

    final ModelDuck model = new ModelDuck();
    model.performFly();
    model.setFlyBehavior(new FlyRocketPowered());
    model.performFly();

    final WildTurkey turkey = new WildTurkey();
    final Duck turkeyAdapter = new TurkeyAdapter(turkey);

    System.out.println("\nThe Turkey says...");
    turkey.gobble();
    turkey.fly();

    System.out.println("\nThe Duck says...");
    testDuck(mallard);
    System.out.println("\nThe TurkeyAdapter says...");
    testDuck(turkeyAdapter);
  }

  private static void testDuck(final Duck duck) {
    duck.performQuack();
    duck.performFly();
  }
}

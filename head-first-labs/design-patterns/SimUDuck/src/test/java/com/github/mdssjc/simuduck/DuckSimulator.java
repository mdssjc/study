package com.github.mdssjc.simuduck;

public class DuckSimulator {

  public static void main(final String[] args) {
    final DuckSimulator simulator = new DuckSimulator();
    simulator.simulate();
  }

  private void simulate() {
    final Quackable mallardDuck = new QuackCounter(new MallardDuck());
    final Quackable redheadDuck = new QuackCounter(new RedheadDuck());
    final Quackable duckCall = new QuackCounter(new DuckCall());
    final Quackable rubberDuck = new QuackCounter(new RubberDuck());
    final GooseAdapter gooseDuck = new GooseAdapter(new Goose());

    System.out.println("\nDuck Simulator: With Decorator");

    simulate(mallardDuck);
    simulate(redheadDuck);
    simulate(duckCall);
    simulate(rubberDuck);
    simulate(gooseDuck);

    System.out.println(
        "The ducks quacked " + QuackCounter.getQuacks() + " times");
  }

  private void simulate(final Quackable duck) {
    duck.quack();
  }
}

package com.github.mdssjc.simuduck;

public class DuckSimulator {

  public static void main(final String[] args) {
    final DuckSimulator simulator = new DuckSimulator();
    final AbstractDuckFactory duckFactory = new CountingDuckFactory();
    simulator.simulate(duckFactory);
  }

  private void simulate(final AbstractDuckFactory duckFactory) {
    final Quackable mallardDuck = duckFactory.createMallardDuck();
    final Quackable redheadDuck = duckFactory.createRedheadDuck();
    final Quackable duckCall = duckFactory.createDuckCall();
    final Quackable rubberDuck = duckFactory.createRubberDuck();
    final GooseAdapter gooseDuck = new GooseAdapter(new Goose());

    System.out.println("\nDuck Simulator:");

    simulate(mallardDuck);
    simulate(redheadDuck);
    simulate(duckCall);
    simulate(rubberDuck);
    simulate(gooseDuck);

    System.out.println("The ducks quacked " +
                       QuackCounter.getQuacks() +
                       " times");
  }

  private void simulate(final Quackable duck) {
    duck.quack();
  }
}

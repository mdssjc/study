package com.github.mdssjc.simuduck;

public class DuckSimulator {

  public static void main(final String[] args) {
    final DuckSimulator simulator = new DuckSimulator();
    simulator.simulate();
  }

  private void simulate() {
    final Quackable mallardDuck = new MallardDuck();
    final Quackable redheadDuck = new RedheadDuck();
    final Quackable duckCall = new DuckCall();
    final Quackable rubberDuck = new RubberDuck();
    final GooseAdapter gooseDuck = new GooseAdapter(new Goose());

    System.out.println("\nDuck Simulator");

    simulate(mallardDuck);
    simulate(redheadDuck);
    simulate(duckCall);
    simulate(rubberDuck);
    simulate(gooseDuck);
  }

  private void simulate(final Quackable duck) {
    duck.quack();
  }
}

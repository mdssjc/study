package com.github.mdssjc.simuduck;

public class DuckSimulator {

  public static void main(String[] args) {
    DuckSimulator simulator = new DuckSimulator();
    simulator.simulate();
  }

  private void simulate() {
    Quackable mallardDuck = new MallardDuck();
    Quackable redheadDuck = new RedheadDuck();
    Quackable duckCall = new DuckCall();
    Quackable rubberDuck = new RubberDuck();
    GooseAdapter gooseDuck = new GooseAdapter(new Goose());

    System.out.println("\nDuck Simulator");

    simulate(mallardDuck);
    simulate(redheadDuck);
    simulate(duckCall);
    simulate(rubberDuck);
    simulate(gooseDuck);
  }

  private void simulate(Quackable duck) {
    duck.quack();
  }
}

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

    final Flock flockOfDucks = new Flock();

    flockOfDucks.add(redheadDuck);
    flockOfDucks.add(duckCall);
    flockOfDucks.add(rubberDuck);
    flockOfDucks.add(gooseDuck);

    final Flock flockOfMallards = new Flock();

    final Quackable mallardOne = duckFactory.createMallardDuck();
    final Quackable mallardTwo = duckFactory.createMallardDuck();
    final Quackable mallardThree = duckFactory.createMallardDuck();
    final Quackable mallardFour = duckFactory.createMallardDuck();

    flockOfMallards.add(mallardOne);
    flockOfMallards.add(mallardTwo);
    flockOfMallards.add(mallardThree);
    flockOfMallards.add(mallardFour);

    flockOfDucks.add(flockOfMallards);

    System.out.println("\nDuck Simulator: Whole Flock Simulation");
    Quackologist quackologist = new Quackologist();
    flockOfDucks.registerObserver(quackologist);
    simulate(flockOfDucks);

    System.out.println("\nDuck Simulator: Mallard Flock Simulation");
    simulate(flockOfMallards);

    System.out.println("\nThe ducks quacked " +
                       QuackCounter.getQuacks() +
                       " times");
  }

  private void simulate(final Quackable duck) {
    duck.quack();
  }
}

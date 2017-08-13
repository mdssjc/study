package com.github.mdssjc.gumball;

import java.util.Random;

public class HasQuarterState implements State {

  private final transient GumballMachine gumballMachine;
  private final Random randomWinner;

  public HasQuarterState(final GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
    this.randomWinner = new Random(System.currentTimeMillis());
  }

  @Override
  public void insertQuarter() {
    System.out.println("You can't insert another quarter");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("Quarter returned");
    this.gumballMachine.setState(this.gumballMachine.getNoQuarterState());
  }

  @Override
  public void turnCrank() {
    System.out.println("You turned...");
    final int winner = this.randomWinner.nextInt(10);
    if (winner == 0 && this.gumballMachine.getCount() > 1) {
      this.gumballMachine.setState(this.gumballMachine.getWinnerState());
    } else {
      this.gumballMachine.setState(this.gumballMachine.getSoldState());
    }
  }

  @Override
  public void dispensed() {
    System.out.println("No gumball dispensed");
  }

  @Override
  public String toString() {
    return "waiting for turn of crank";
  }
}

package com.github.mdssjc.gumball;

public class WinnerState implements State {

  private final GumballMachine gumballMachine;

  public WinnerState(final GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("Please wait, we're already giving you a Gumball");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("Please wait, we're already giving you a Gumball");
  }

  @Override
  public void turnCrank() {
    System.out.println("Turning again doesn't get you another gumball!");
  }

  @Override
  public void dispensed() {
    System.out.println(
        "YOU'RE A WINNER! You get two gumballs for your quarter");
    this.gumballMachine.releaseBall();
    if (this.gumballMachine.getCount() == 0) {
      this.gumballMachine.setState(this.gumballMachine.getSoldOutState());
    } else {
      this.gumballMachine.releaseBall();
      if (this.gumballMachine.getCount() > 0) {
        this.gumballMachine.setState(this.gumballMachine.getNoQuarterState());
      } else {
        System.out.println("Oops, out of gumballs!");
        this.gumballMachine.setState(this.gumballMachine.getSoldOutState());
      }
    }
  }

  @Override
  public String toString() {
    return "despensing two gumballs for your quarter, because YOU'RE A WINNER!";
  }
}

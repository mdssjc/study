package com.github.mdssjc.gumball;

public class NoQuarterState implements State {

  private final GumballMachine gumballMachine;

  public NoQuarterState(final GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("You inserted a quarter");
    this.gumballMachine.setState(this.gumballMachine.getHasQuarterState());
  }

  @Override
  public void ejectQuarter() {
    System.out.println("You haven't inserted a quarter");
  }

  @Override
  public void turnCrank() {
    System.out.println("You turned, but there's no quarter");
  }

  @Override
  public void dispensed() {
    System.out.println("You need to pay first");
  }

  @Override
  public String toString() {
    return "waiting for quarter";
  }
}

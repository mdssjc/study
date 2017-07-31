package com.github.mdssjc.gumball;

public class HasQuarterState implements State {

  private final GumballMachine gumballMachine;

  public HasQuarterState(final GumballMachine gumballMachine) {
    this.gumballMachine = gumballMachine;
  }

  @Override
  public void insertQuarter() {
    System.out.println("You can’t insert another quarter");
  }

  @Override
  public void ejectQuarter() {
    System.out.println("Quarter returned");
    this.gumballMachine.setState(this.gumballMachine.getNoQuarterState());
  }

  @Override
  public void turnCrank() {
    System.out.println("You turned...");
    this.gumballMachine.setState(this.gumballMachine.getSoldState());
  }

  @Override
  public void dispensed() {
    System.out.println("No gumball dispensed");
  }
}

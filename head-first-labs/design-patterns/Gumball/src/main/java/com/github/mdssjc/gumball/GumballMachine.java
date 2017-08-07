package com.github.mdssjc.gumball;

import lombok.Getter;
import lombok.Setter;

public class GumballMachine {

  @Getter
  private final State soldOutState;
  @Getter
  private final State noQuarterState;
  @Getter
  private final State hasQuarterState;
  @Getter
  private final State soldState;
  @Getter
  private final State winnerState;

  @Getter
  @Setter
  private State state;
  @Getter
  private int count;
  @Getter
  private final String location;

  public GumballMachine(final String location, final int numberGumballs) {
    this.location = location;
    this.soldOutState = new SoldOutState(this);
    this.noQuarterState = new NoQuarterState(this);
    this.hasQuarterState = new HasQuarterState(this);
    this.soldState = new SoldState(this);
    this.winnerState = new WinnerState(this);

    this.count = numberGumballs;
    this.state = this.soldOutState;
    if (numberGumballs > 0) {
      this.state = this.noQuarterState;
    }
  }

  public void insertQuarter() {
    this.state.insertQuarter();
  }

  public void ejectQuarter() {
    this.state.ejectQuarter();
  }

  public void turnCrank() {
    this.state.turnCrank();
    this.state.dispensed();
  }

  void releaseBall() {
    System.out.println("A gumball comes rolling out the slot...");
    if (this.count != 0) {
      this.count = this.count - 1;
    }
  }

  public void refill(final int numGumBalls) {
    this.count = numGumBalls;
    this.state = this.noQuarterState;
  }

  @Override
  public String toString() {
    final StringBuffer result = new StringBuffer();
    result.append("\nMighty Gumball, Inc.");
    result.append("\nJava-enabled Standing Gumball Model #2004\n");
    result.append("Inventory: " + this.count + " gumball");
    if (this.count != 1) {
      result.append("s");
    }
    result.append("\nMachine is ");
    result.append(this.state);
    result.append("\n");
    return result.toString();
  }
}

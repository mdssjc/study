package com.github.mdssjc.gumball;

public class GumballMachine {

  private final static int SOLD_OUT = 0;
  private final static int NO_QUARTER = 1;
  private final static int HAS_QUARTER = 2;
  private final static int SOLD = 3;

  private int state = SOLD_OUT;
  private int count;

  public GumballMachine(final int count) {
    this.count = count;
    if (count > 0) {
      this.state = NO_QUARTER;
    }
  }

  public void insertQuarter() {
    if (this.state == HAS_QUARTER) {
      System.out.println("You can’t insert another quarter");
    } else if (this.state == NO_QUARTER) {
      this.state = HAS_QUARTER;
      System.out.println("You inserted a quarter");
    } else if (this.state == SOLD_OUT) {
      System.out.println("You can’t insert a quarter, the machine is sold out");
    } else if (this.state == SOLD) {
      System.out.println("Please wait, we’re already giving you a gumball");
    }
  }

  public void ejectQuarter() {
    if (this.state == HAS_QUARTER) {
      System.out.println("Quarter returned");
      this.state = NO_QUARTER;
    } else if (this.state == NO_QUARTER) {
      System.out.println("You haven’t inserted a quarter");
    } else if (this.state == SOLD) {
      System.out.println("Sorry, you already turned the crank");
    } else if (this.state == SOLD_OUT) {
      System.out.println("You can’t eject, you haven’t inserted a quarter yet");
    }
  }

  public void turnCrank() {
    if (this.state == SOLD) {
      System.out.println("Turning twice doesn’t get you another gumball !");
    } else if (this.state == NO_QUARTER) {
      System.out.println("You turned but there’s no quarter");
    } else if (this.state == SOLD_OUT) {
      System.out.println("You turned, but there are no gumballs");
    } else if (this.state == HAS_QUARTER) {
      System.out.println("You turned...");
      this.state = SOLD;
      dispense();
    }
  }

  private void dispense() {
    if (this.state == SOLD) {
      System.out.println("A gumball comes rolling out the slot");
      this.count = this.count - 1;
      if (this.count == 0) {
        System.out.println("Oops, out of gumballs !");
        this.state = SOLD_OUT;
      } else {
        this.state = NO_QUARTER;
      }
    } else if (this.state == NO_QUARTER) {
      System.out.println("You need to pay first");
    } else if (this.state == SOLD_OUT) {
      System.out.println("No gumball dispensed");
    } else if (this.state == HAS_QUARTER) {
      System.out.println("No gumball dispensed");
    }
  }
}

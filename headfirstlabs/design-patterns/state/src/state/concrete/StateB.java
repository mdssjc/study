package state.concrete;

import context.Context;
import state.State;

public class StateB implements State {

  private final Context context;

  public StateB(final Context context) {
    this.context = context;
  }

  @Override
  public void stateA() {
    System.out.println("Set state A");
    this.context.setState(this.context.getStateA());
  }

  @Override
  public void stateB() {
    System.out.println("State B");
  }

  @Override
  public void stateC() {
    System.out.println("Set state C");
    this.context.setState(this.context.getStateC());
  }
}

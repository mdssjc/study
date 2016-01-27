package state.concrete;

import context.Context;
import state.State;

public class StateA implements State {

  private final Context context;

  public StateA(final Context context) {
    this.context = context;
  }

  @Override
  public void stateA() {
    System.out.println("State A");
  }

  @Override
  public void stateB() {
    System.out.println("Set state B");
    this.context.setState(this.context.getStateB());
  }

  @Override
  public void stateC() {
    System.out.println("Nops");
  }
}

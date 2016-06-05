package state.concrete;

import context.Context;
import state.State;

public class StateC implements State {

  private final Context context;

  public StateC(final Context context) {
    this.context = context;
  }

  @Override
  public void handleA() {
    System.out.println("Nops");
  }

  @Override
  public void handleB() {
    System.out.println("Set state B");
    this.context.setState(this.context.getStateB());
  }

  @Override
  public void handleC() {
    System.out.println("State C");
  }
}

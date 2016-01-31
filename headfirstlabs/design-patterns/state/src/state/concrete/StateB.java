package state.concrete;

import context.Context;
import state.State;

public class StateB implements State {

  private final Context context;

  public StateB(final Context context) {
    this.context = context;
  }

  @Override
  public void handleA() {
    System.out.println("Set state A");
    this.context.setState(this.context.getStateA());
  }

  @Override
  public void handleB() {
    System.out.println("State B");
  }

  @Override
  public void handleC() {
    System.out.println("Set state C");
    this.context.setState(this.context.getStateC());
  }
}

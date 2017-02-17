package com.github.mdssjc.dp.state.concrete;

import com.github.mdssjc.dp.state.State;
import com.github.mdssjc.dp.state.context.Context;

/**
 * Implementação do StateB.
 *
 * @author Marcelo dos Santos
 *
 */
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

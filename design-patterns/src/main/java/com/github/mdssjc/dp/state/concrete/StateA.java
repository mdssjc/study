package com.github.mdssjc.dp.state.concrete;

import com.github.mdssjc.dp.state.State;
import com.github.mdssjc.dp.state.context.Context;

/**
 * Implementação do StateA.
 *
 * @author Marcelo dos Santos
 *
 */
public class StateA implements State {

  private final Context context;

  public StateA(final Context context) {
    this.context = context;
  }

  @Override
  public void handleA() {
    System.out.println("State A");
  }

  @Override
  public void handleB() {
    System.out.println("Set state B");
    this.context.setState(this.context.getStateB());
  }

  @Override
  public void handleC() {
    System.out.println("Nops");
  }
}

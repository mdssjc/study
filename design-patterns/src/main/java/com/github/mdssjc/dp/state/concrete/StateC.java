package com.github.mdssjc.dp.state.concrete;

import com.github.mdssjc.dp.state.State;
import com.github.mdssjc.dp.state.context.Context;

/**
 * Implementação do StateC.
 *
 * @author Marcelo dos Santos
 *
 */
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

package com.github.mdssjc.dp.state.context;

import com.github.mdssjc.dp.state.State;
import com.github.mdssjc.dp.state.concrete.StateA;
import com.github.mdssjc.dp.state.concrete.StateB;
import com.github.mdssjc.dp.state.concrete.StateC;

/**
 * Implementação do Context.
 *
 * @author Marcelo dos Santos
 *
 */
public class Context {

  private final State stateA;
  private final State stateB;
  private final State stateC;

  private State state;

  public Context() {
    this.state = new StateA(this);
    this.stateA = new StateA(this);
    this.stateB = new StateB(this);
    this.stateC = new StateC(this);
  }

  public void requestA() {
    this.state.handleA();
  }

  public void requestB() {
    this.state.handleB();
  }

  public void requestC() {
    this.state.handleC();
  }

  public void setState(final State state) {
    this.state = state;
  }

  public State getStateA() {
    return this.stateA;
  }

  public State getStateB() {
    return this.stateB;
  }

  public State getStateC() {
    return this.stateC;
  }
}

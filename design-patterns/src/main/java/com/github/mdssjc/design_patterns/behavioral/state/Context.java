package com.github.mdssjc.design_patterns.behavioral.state;

/**
 * Context.
 *
 * @author Marcelo dos Santos
 *
 */
public class Context {

  private final State stateA;
  private final State stateB;
  private State state;

  public Context() {
    this.stateA = new ConcreteStateA();
    this.stateB = new ConcreteStateB();
    this.state = this.stateA;
  }

  public void request() {
    this.state.handle();
    this.state = (this.state instanceof ConcreteStateA)
                 ? this.stateB
                 : this.stateA;
  }
}

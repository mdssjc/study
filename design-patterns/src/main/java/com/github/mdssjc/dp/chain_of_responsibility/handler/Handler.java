package com.github.mdssjc.dp.chain_of_responsibility.handler;

/**
 * Classe Abstrata Handler.
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class Handler {

  protected Handler successor;

  public abstract void handleRequest(Object message);

  public void nextSuccessor(final Handler next) {
    this.successor = next;
  }
}

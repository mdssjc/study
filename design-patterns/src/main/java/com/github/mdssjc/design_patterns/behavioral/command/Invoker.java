package com.github.mdssjc.design_patterns.behavioral.command;

/**
 * Invoker.
 *
 * @author Marcelo dos Santos
 *
 */
public class Invoker {

  private final Command command;

  public Invoker(final Command command) {
    this.command = command;
  }

  public String message() {
    return this.command.execute();
  }
}

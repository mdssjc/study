package com.github.mdssjc.design_patterns.behavioral.command;

/**
 * Concrete Command.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteCommand implements Command {

  private final Receiver receiver;

  public ConcreteCommand(final Receiver receiver) {
    this.receiver = receiver;
  }

  @Override
  public String execute() {
    return this.receiver.action();
  }
}

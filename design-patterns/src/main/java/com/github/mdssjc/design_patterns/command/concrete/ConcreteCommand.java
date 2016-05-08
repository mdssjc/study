package com.github.mdssjc.design_patterns.command.concrete;

import com.github.mdssjc.design_patterns.command.Command;
import com.github.mdssjc.design_patterns.command.receiver.Receiver;

import lombok.AllArgsConstructor;

/**
 * Classe Command.
 *
 * @author mdssjc &lt;Marcelo dos Santos&gt;
 *
 */
@AllArgsConstructor
public class ConcreteCommand implements Command {

  private final Receiver receiver;

  @Override
  public void execute() {
    this.receiver.message();
  }

  @Override
  public void undo() {
  }

  @Override
  public void store() {
  }

  @Override
  public void load() {
  }
}

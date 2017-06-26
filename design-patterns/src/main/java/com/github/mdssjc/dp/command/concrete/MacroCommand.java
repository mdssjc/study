package com.github.mdssjc.dp.command.concrete;

import com.github.mdssjc.dp.command.Command;

/**
 * Classe MacroCommand.
 * <p>
 * Implementação da extensão do comando.
 *
 * @author Marcelo dos Santos
 *
 */
public class MacroCommand implements Command {

  private final Command[] commands;

  public MacroCommand(final Command[] commands) {
    this.commands = commands;
  }

  @Override
  public void execute() {
    for (final Command command : this.commands) {
      command.execute();
    }
  }

  @Override
  public void undo() {
    for (final Command command : this.commands) {
      command.undo();
    }
  }

  @Override
  public void store() {
    for (final Command command : this.commands) {
      command.store();
    }
  }

  @Override
  public void load() {
    for (final Command command : this.commands) {
      command.load();
    }
  }
}

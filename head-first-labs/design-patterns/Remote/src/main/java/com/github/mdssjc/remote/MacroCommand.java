package com.github.mdssjc.remote;

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
  }
}

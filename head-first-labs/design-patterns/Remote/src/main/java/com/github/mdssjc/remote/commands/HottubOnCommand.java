package com.github.mdssjc.remote.commands;

import com.github.mdssjc.remote.Command;
import com.github.mdssjc.remote.Hottub;

public class HottubOnCommand implements Command {

  private final Hottub hottub;

  public HottubOnCommand(final Hottub hottub) {
    this.hottub = hottub;
  }

  @Override
  public void execute() {
    this.hottub.on();
  }

  @Override
  public void undo() {
    this.hottub.off();
  }
}

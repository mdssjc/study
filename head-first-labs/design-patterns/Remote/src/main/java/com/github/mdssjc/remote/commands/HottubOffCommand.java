package com.github.mdssjc.remote.commands;

import com.github.mdssjc.remote.Command;
import com.github.mdssjc.remote.Hottub;

public class HottubOffCommand implements Command {

  private final Hottub hottub;

  public HottubOffCommand(final Hottub hottub) {
    this.hottub = hottub;
  }

  @Override
  public void execute() {
    this.hottub.off();
  }

  @Override
  public void undo() {
    this.hottub.on();
  }
}

package com.github.mdssjc.remote.commands;

import com.github.mdssjc.remote.Command;
import com.github.mdssjc.remote.TV;

public class TVOnCommand implements Command {

  private TV tv;

  public TVOnCommand(TV tv) {
    this.tv = tv;
  }

  @Override
  public void execute() {
    tv.on();
  }

  @Override
  public void undo() {
    tv.off();
  }
}

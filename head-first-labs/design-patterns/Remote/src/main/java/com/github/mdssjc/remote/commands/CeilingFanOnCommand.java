package com.github.mdssjc.remote.commands;

import com.github.mdssjc.remote.CeilingFan;
import com.github.mdssjc.remote.Command;

public class CeilingFanOnCommand implements Command {

  private final CeilingFan ceilingFan;

  public CeilingFanOnCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    this.ceilingFan.high();
  }

  @Override
  public void undo() {
    this.ceilingFan.off();
  }
}

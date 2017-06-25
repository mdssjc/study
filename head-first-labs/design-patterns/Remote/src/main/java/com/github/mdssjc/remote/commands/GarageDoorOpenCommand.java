package com.github.mdssjc.remote.commands;

import com.github.mdssjc.remote.Command;
import com.github.mdssjc.remote.GarageDoor;

public class GarageDoorOpenCommand implements Command {

  private final GarageDoor garageDoor;

  public GarageDoorOpenCommand(final GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    this.garageDoor.up();
  }

  @Override
  public void undo() {
    this.garageDoor.down();
  }
}

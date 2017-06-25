package com.github.mdssjc.remote.commands;

import com.github.mdssjc.remote.Command;
import com.github.mdssjc.remote.GarageDoor;

public class GarageDoorUpCommand implements Command {

  private final GarageDoor garageDoor;

  public GarageDoorUpCommand(final GarageDoor garageDoor) {
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

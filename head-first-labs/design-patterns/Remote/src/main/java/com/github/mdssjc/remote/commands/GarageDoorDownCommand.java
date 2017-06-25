package com.github.mdssjc.remote.commands;

public class GarageDoorDownCommand implements Command {

  private final GarageDoor garageDoor;

  public GarageDoorDownCommand(final GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    this.garageDoor.down();
  }

  @Override
  public void undo() {
    this.garageDoor.up();
  }
}

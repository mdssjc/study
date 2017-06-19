package com.github.mdssjc.remote;

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

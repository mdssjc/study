package com.github.mdssjc.remote;

public class GarageDoorUpCommand implements Command {

  private final GarageDoor garageDoor;

  public GarageDoorUpCommand(final GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    this.garageDoor.up();
  }
}

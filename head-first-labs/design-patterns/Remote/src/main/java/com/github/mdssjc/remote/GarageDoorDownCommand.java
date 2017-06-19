package com.github.mdssjc.remote;

public class GarageDoorDownCommand implements Command {

  private final GarageDoor garageDoor;

  public GarageDoorDownCommand(final GarageDoor garageDoor) {
    this.garageDoor = garageDoor;
  }

  @Override
  public void execute() {
    this.garageDoor.down();
  }
}

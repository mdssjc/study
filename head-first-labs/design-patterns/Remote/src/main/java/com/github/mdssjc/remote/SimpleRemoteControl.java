package com.github.mdssjc.remote;

public class SimpleRemoteControl {

  private Command slot;

  public void setCommand(final Command command) {
    this.slot = command;
  }

  public void buttonWasPressed() {
    this.slot.execute();
  }
}

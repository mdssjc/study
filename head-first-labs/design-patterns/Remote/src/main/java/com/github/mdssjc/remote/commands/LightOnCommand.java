package com.github.mdssjc.remote.commands;

import com.github.mdssjc.remote.Command;
import com.github.mdssjc.remote.Light;

public class LightOnCommand implements Command {

  private final Light light;

  public LightOnCommand(final Light light) {
    this.light = light;
  }

  @Override
  public void execute() {
    this.light.on();
  }

  @Override
  public void undo() {
    this.light.off();
  }
}

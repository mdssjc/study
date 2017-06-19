package com.github.mdssjc.remote;

public class CeilingFanOnCommand implements Command {

  private final CeilingFan ceilingFan;

  public CeilingFanOnCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    this.ceilingFan.high();
  }
}

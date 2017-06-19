package com.github.mdssjc.remote;

public class CeilingFanOffCommand implements Command {

  private final CeilingFan ceilingFan;

  public CeilingFanOffCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    this.ceilingFan.off();
  }

  @Override
  public void undo() {
    this.ceilingFan.high();
  }
}

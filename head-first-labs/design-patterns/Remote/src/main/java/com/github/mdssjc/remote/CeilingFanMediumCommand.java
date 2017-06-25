package com.github.mdssjc.remote;

public class CeilingFanMediumCommand implements Command {

  private final CeilingFan ceilingFan;
  private CeilingFan.Level prevSpeed;

  public CeilingFanMediumCommand(final CeilingFan ceilingFan) {
    this.ceilingFan = ceilingFan;
  }

  @Override
  public void execute() {
    this.prevSpeed = this.ceilingFan.getSpeed();
    this.ceilingFan.medium();
  }

  @Override
  public void undo() {
    if (this.prevSpeed == CeilingFan.Level.HIGH) {
      this.ceilingFan.high();
    } else if (this.prevSpeed == CeilingFan.Level.MEDIUM) {
      this.ceilingFan.medium();
    } else if (this.prevSpeed == CeilingFan.Level.LOW) {
      this.ceilingFan.low();
    } else if (this.prevSpeed == CeilingFan.Level.OFF) {
      this.ceilingFan.off();
    }
  }
}

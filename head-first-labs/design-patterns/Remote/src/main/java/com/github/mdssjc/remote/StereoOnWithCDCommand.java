package com.github.mdssjc.remote;

public class StereoOnWithCDCommand implements Command {

  private final Stereo stereo;

  public StereoOnWithCDCommand(final Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    this.stereo.on();
    this.stereo.setCD();
    this.stereo.setVolume(11);
  }

  @Override
  public void undo() {
    this.stereo.off();
  }
}

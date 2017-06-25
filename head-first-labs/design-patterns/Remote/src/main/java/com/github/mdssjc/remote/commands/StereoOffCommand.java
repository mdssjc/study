package com.github.mdssjc.remote.commands;

import com.github.mdssjc.remote.Command;
import com.github.mdssjc.remote.Stereo;

public class StereoOffCommand implements Command {

  private final Stereo stereo;

  public StereoOffCommand(final Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    this.stereo.off();
  }

  @Override
  public void undo() {
    this.stereo.on();
    this.stereo.setCD();
    this.stereo.setVolume(11);
  }
}

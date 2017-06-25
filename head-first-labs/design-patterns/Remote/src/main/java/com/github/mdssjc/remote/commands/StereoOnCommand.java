package com.github.mdssjc.remote.commands;

import com.github.mdssjc.remote.Command;
import com.github.mdssjc.remote.Stereo;

public class StereoOnCommand implements Command {

  private final Stereo stereo;

  public StereoOnCommand(final Stereo stereo) {
    this.stereo = stereo;
  }

  @Override
  public void execute() {
    this.stereo.on();
  }

  @Override
  public void undo() {
    this.stereo.off();
  }
}

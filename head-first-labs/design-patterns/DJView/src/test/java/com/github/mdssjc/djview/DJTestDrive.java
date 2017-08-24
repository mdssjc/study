package com.github.mdssjc.djview;

public class DJTestDrive {

  public static void main(final String[] args) {
    final BeatModelInterface model = new BeatModel();
    final ControllerInterface controller = new BeatController(model);
  }
}

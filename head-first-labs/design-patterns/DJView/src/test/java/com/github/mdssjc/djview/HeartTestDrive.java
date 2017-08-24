package com.github.mdssjc.djview;

public class HeartTestDrive {

  public static void main(final String[] args) {
    final HeartModel heartModel = new HeartModel();
    final ControllerInterface model = new HeartController(heartModel);
  }
}

package com.github.mdssjc.djview;

public class HeartController implements ControllerInterface {

  private HeartModelInterface model;
  private DJView view;

  public HeartController(HeartModelInterface model) {
    this.model = model;
    view = new DJView(this, new HeartAdapter(model));
    view.createView();
    view.createControls();
    view.disableStopMenuItem();
    view.disableStartMenuItem();
  }

  @Override
  public void start() {
  }

  @Override
  public void stop() {
  }

  @Override
  public void increaseBPM() {
  }

  @Override
  public void decreaseBPM() {
  }

  @Override
  public void setBPM(final int bpm) {
  }
}

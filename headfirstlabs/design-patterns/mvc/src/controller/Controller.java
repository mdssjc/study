package controller;

import model.Model;
import view.View;

public class Controller implements ControllerInterface {

  private final Model model;
  private final View  view;
  private int         counter;

  public Controller(final Model model) {
    this.model = model;
    this.view = new View(this, model);
  }

  @Override
  public void visibility(final boolean show) {
    if (show) {
      this.view.show();
    } else {
      this.view.hide();
    }
  }

  @Override
  public void nextMessage() {
    if (this.counter < 10) {
      this.model.nextMessage();
    } else if (this.counter < 20) {
      this.model.prevMessage();
    } else {
      this.counter = -1;
    }
    this.counter++;
  }

  @Override
  public View getView() {
    return this.view;
  }
}

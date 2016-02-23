package controller;

import view.View;

public interface ControllerInterface {

  void visibility(boolean show);

  void nextMessage();

  View getView();
}

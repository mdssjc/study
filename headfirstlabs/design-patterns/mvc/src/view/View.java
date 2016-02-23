package view;

import java.util.Observable;
import java.util.Observer;

import controller.ControllerInterface;
import model.Model;

public class View implements Observer {

  private final ControllerInterface controller;
  private final Model               model;
  private String                    message;
  private boolean                   show;

  public View(final ControllerInterface controller, final Model model) {
    this.controller = controller;
    this.model = model;

    this.model.addObserver(this);
  }

  public void show() {
    System.out.println("Show message");
    this.show = true;
  }

  public void hide() {
    System.out.println("Hide message");
    this.show = false;
  }

  public void printMessage() {
    if (this.show) {
      if (this.message != null) {
        System.out.println("<Message>");
        System.out.println(this.message.toUpperCase());
        System.out.println("<Message>");
      } else {
        System.out.println("---");
      }
    }
  }

  public void goMessage() {
    System.out.println("Request new message");
    this.controller.visibility(false);
    this.controller.nextMessage();
  }

  @Override
  public void update(final Observable o, final Object arg) {
    System.out.println("New message incoming");
    this.controller.visibility(true);
    this.message = this.model.getMessage();
  }
}

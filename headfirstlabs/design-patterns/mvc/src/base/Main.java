/*
 * Design Pattern
 * Compound Patterns - MVC (Model View Controller)
 *
 */
package base;

import controller.Controller;
import model.Model;
import view.View;

public class Main {

  public static void main(final String[] args) {
    final Controller controller = new Controller(new Model());
    final View view = controller.getView();
    view.show();
    view.printMessage();
    view.goMessage();
    view.printMessage();
    view.goMessage();
    view.printMessage();
  }
}

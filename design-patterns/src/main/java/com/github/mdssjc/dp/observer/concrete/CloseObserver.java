package com.github.mdssjc.dp.observer.concrete;

import java.util.Observable;
import java.util.Observer;

/**
 * Classe CloseObserver.
 *
 * @author Marcelo dos Santos
 *
 */
public class CloseObserver implements Observer {

  private boolean flag = true;

  @Override
  public void update(final Observable o, final Object arg) {
    if (arg instanceof Boolean) {
      this.flag = (boolean) arg;
    }
  }

  public boolean isClose() {
    return this.flag;
  }
}

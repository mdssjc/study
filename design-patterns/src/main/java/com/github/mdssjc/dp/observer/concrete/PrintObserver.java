package com.github.mdssjc.dp.observer.concrete;

import java.util.Observable;
import java.util.Observer;

/**
 * Classe PrintObserver.
 *
 * @author Marcelo dos Santos
 *
 */
public class PrintObserver implements Observer {

  @Override
  public void update(final Observable o, final Object arg) {
    if (arg instanceof Integer) {
      System.out.println(arg);
    }
  }
}

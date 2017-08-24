package com.github.mdssjc.djview;

import javax.swing.*;
import java.util.logging.Logger;

public class BeatBar extends JProgressBar implements Runnable {

  private final Thread thread;
  private JProgressBar progressBar;

  public BeatBar() {
    this.thread = new Thread(this);
    setMaximum(100);
    this.thread.start();
  }

  public void run() {
    while (true) {
      int value = getValue();
      value = (int) (value * .75);
      setValue(value);
      repaint();
      try {
        Thread.sleep(50);
      } catch (final Exception e) {
        Logger.getGlobal()
              .info(e.getMessage());
      }
    }
  }
}

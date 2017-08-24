package com.github.mdssjc.djview;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

public class HeartModel implements HeartModelInterface, Runnable {

  private final List<BeatObserver> beatObservers = new ArrayList<>();
  private final List<BPMObserver> bpmObservers = new ArrayList<>();
  private int time = 1000;
  private final int bpm = 90;
  private final Random random = new Random(System.currentTimeMillis());
  private final Thread thread;

  public HeartModel() {
    this.thread = new Thread(this);
    this.thread.start();
  }

  public void run() {
    int lastrate = -1;

    while (true) {
      int change = this.random.nextInt(10);
      if (this.random.nextInt(2) == 0) {
        change = 0 - change;
      }
      final int rate = 60000 / (this.time + change);
      if (rate < 120 && rate > 50) {
        this.time += change;
        notifyBeatObservers();
        if (rate != lastrate) {
          lastrate = rate;
          notifyBPMObservers();
        }
      }
      try {
        Thread.sleep(this.time);
      } catch (final Exception e) {
        Logger.getGlobal()
              .info(e.getMessage());
      }
    }
  }

  public int getHeartRate() {
    return 60000 / this.time;
  }

  public void registerObserver(final BeatObserver o) {
    this.beatObservers.add(o);
  }

  public void removeObserver(final BeatObserver o) {
    final int i = this.beatObservers.indexOf(o);
    if (i >= 0) {
      this.beatObservers.remove(i);
    }
  }

  public void notifyBeatObservers() {
    for (final BeatObserver observer : this.beatObservers) {
      observer.updateBeat();
    }
  }

  public void registerObserver(final BPMObserver o) {
    this.bpmObservers.add(o);
  }

  public void removeObserver(final BPMObserver o) {
    final int i = this.bpmObservers.indexOf(o);
    if (i >= 0) {
      this.bpmObservers.remove(i);
    }
  }

  public void notifyBPMObservers() {
    for (final BPMObserver observer : this.bpmObservers) {
      observer.updateBPM();
    }
  }
}

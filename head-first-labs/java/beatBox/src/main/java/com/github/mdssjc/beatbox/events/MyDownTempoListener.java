package com.github.mdssjc.beatbox.events;

import com.github.mdssjc.beatbox.BeatBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyDownTempoListener implements ActionListener {

  private final BeatBox beatBox;

  public MyDownTempoListener(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    final float tempoFactor = this.beatBox.getSequencer()
                                          .getTempoFactor();
    this.beatBox.getSequencer()
                .setTempoFactor(tempoFactor * 0.97F);
  }
}

package com.github.mdssjc.beatbox.events;

import com.github.mdssjc.beatbox.BeatBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyUpTempoListener implements ActionListener {

  private final BeatBox beatBox;

  public MyUpTempoListener(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    final float tempoFactor = this.beatBox.getSequencer()
                                          .getTempoFactor();
    this.beatBox.getSequencer()
                .setTempoFactor(tempoFactor * 1.03F);
  }
}

package com.github.mdssjc.beatbox.events;

import com.github.mdssjc.beatbox.BeatBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyStartListener implements ActionListener {

  private final BeatBox beatBox;

  public MyStartListener(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    this.beatBox.buildTrackAndStart();
  }
}

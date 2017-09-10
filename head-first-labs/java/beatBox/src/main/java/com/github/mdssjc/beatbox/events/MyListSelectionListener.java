package com.github.mdssjc.beatbox.events;

import com.github.mdssjc.beatbox.BeatBox;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyListSelectionListener implements ListSelectionListener {

  private final BeatBox beatBox;

  public MyListSelectionListener(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  @Override
  public void valueChanged(final ListSelectionEvent e) {
    if (!e.getValueIsAdjusting()) {
      final String selected = (String) this.beatBox.getIncomingList().getSelectedValue();
      if (selected != null) {
        final boolean[] selectedState = this.beatBox.getOtherSeqsMap().get(selected);
        beatBox.changeSequence(selectedState);
        this.beatBox.getSequencer().stop();
        this.beatBox.buildTrackAndStart();
      }
    }
  }
}

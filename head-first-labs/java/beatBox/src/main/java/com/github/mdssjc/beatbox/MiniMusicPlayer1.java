package com.github.mdssjc.beatbox;

import javax.sound.midi.*;
import java.util.logging.Logger;

public class MiniMusicPlayer1 {

  public static void main(final String[] args) {
    try {
      final Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();

      final Sequence seq = new Sequence(Sequence.PPQ, 4);
      final Track track = seq.createTrack();

      for (int i = 5; i < 61; i += 4) {
        track.add(makeEvent(144, 1, i, 100, i));
        track.add(makeEvent(128, 1, i, 100, i + 2));
      }

      sequencer.setSequence(seq);
      sequencer.setTempoInBPM(220);
      sequencer.start();
    } catch (final Exception ex) {
      Logger.getGlobal()
            .info(ex.getMessage());
    }
  }

  public static MidiEvent makeEvent(final int comd, final int chan, final int one, final int two, final int tick) {
    MidiEvent event = null;

    try {
      final ShortMessage a = new ShortMessage();
      a.setMessage(comd, chan, one, two);
      event = new MidiEvent(a, tick);
    } catch (final Exception e) {
      Logger.getGlobal()
            .info(e.getMessage());
    }
    return event;
  }
}

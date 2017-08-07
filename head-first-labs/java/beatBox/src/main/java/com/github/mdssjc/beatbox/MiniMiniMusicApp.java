package com.github.mdssjc.beatbox;

import javax.sound.midi.*;
import java.util.logging.Logger;

public class MiniMiniMusicApp {

  public static void main(final String[] args) {
    final MiniMiniMusicApp mini = new MiniMiniMusicApp();
    mini.play();
  }

  public void play() {
    try {
      final Sequencer player = MidiSystem.getSequencer();
      player.open();

      final Sequence seq = new Sequence(Sequence.PPQ, 4);

      final Track track = seq.createTrack();

      final ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, 44, 100);
      final MidiEvent noteOn = new MidiEvent(a, 1L);
      track.add(noteOn);

      final ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, 44, 100);
      final MidiEvent noteOff = new MidiEvent(b, 16L);
      track.add(noteOff);

      player.setSequence(seq);
      player.start();
    } catch (final MidiUnavailableException | InvalidMidiDataException e) {
      Logger.getGlobal()
            .info(e.getMessage());
    }
  }
}

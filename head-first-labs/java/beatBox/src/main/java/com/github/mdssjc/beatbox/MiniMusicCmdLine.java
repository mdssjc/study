package com.github.mdssjc.beatbox;

import javax.sound.midi.*;
import java.util.logging.Logger;

public class MiniMusicCmdLine {

  private static final long SLEEP = 2000L;

  public static void main(final String[] args) {
    final MiniMusicCmdLine mini = new MiniMusicCmdLine();

    if (args.length < 2) {
      System.out.println("Don't forget the instrument and note args");
      try {
        mini.play(102, 30);
        Thread.sleep(SLEEP);
        mini.play(80, 20);
        Thread.sleep(SLEEP);
        mini.play(40, 70);
      } catch (final InterruptedException e) {
        Logger.getGlobal()
              .info(e.getMessage());
      }
    } else {
      final int instrument = Integer.parseInt(args[0]);
      final int note = Integer.parseInt(args[1]);
      mini.play(instrument, note);
    }
  }

  public void play(final int instrument, final int note) {
    try {
      final Sequencer player = MidiSystem.getSequencer();
      player.open();
      final Sequence seq = new Sequence(Sequence.PPQ, 4);
      final Track track = seq.createTrack();
      final MidiEvent event = null;

      final ShortMessage first = new ShortMessage();
      first.setMessage(192, 1, instrument, 0);
      final MidiEvent changeInstrument = new MidiEvent(first, 1L);
      track.add(changeInstrument);

      final ShortMessage a = new ShortMessage();
      a.setMessage(144, 1, note, 100);
      final MidiEvent noteOn = new MidiEvent(a, 1L);
      track.add(noteOn);

      final ShortMessage b = new ShortMessage();
      b.setMessage(128, 1, note, 100);
      final MidiEvent noteOff = new MidiEvent(b, 16L);
      track.add(noteOff);

      player.setSequence(seq);
      player.start();
    } catch (final Exception ex) {
      Logger.getGlobal()
            .info(ex.getMessage());
    }
  }
}

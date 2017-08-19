package com.github.mdssjc.beatbox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class MiniMusicPlayer3 {

  private static final JFrame f = new JFrame("My First Music Video");
  private static MyDrawPanel ml;

  public static void main(final String[] args) {
    final MiniMusicPlayer3 mini = new MiniMusicPlayer3();
    mini.go();
  }

  public void setUpGui() {
    ml = new MyDrawPanel();
    f.setContentPane(ml);
    f.setBounds(30, 30, 300, 300);
    f.setVisible(true);
  }

  public void go() {
    setUpGui();

    try {
      final Sequencer sequencer = MidiSystem.getSequencer();
      sequencer.open();
      sequencer.addControllerEventListener(ml, new int[]{127});
      final Sequence seq = new Sequence(Sequence.PPQ, 4);
      final Track track = seq.createTrack();

      int r;
      for (int i = 0; i < 60; i += 4) {
        r = (int) ((Math.random() * 50) + 1);
        track.add(makeEvent(144, 1, r, 100, i));
        track.add(makeEvent(176, 1, 127, 0, i));
        track.add(makeEvent(128, 1, r, 100, i + 2));
      }

      sequencer.setSequence(seq);
      sequencer.start();
      sequencer.setTempoInBPM(120);
    } catch (final Exception ex) {
      Logger.getGlobal()
            .info(ex.getMessage());
    }
  }

  public MidiEvent makeEvent(final int comd, final int chan, final int one, final int two, final int tick) {
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

  class MyDrawPanel extends JPanel implements ControllerEventListener {

    boolean msg = false;

    public void controlChange(final ShortMessage event) {
      this.msg = true;
      repaint();
    }

    public void paintComponent(final Graphics g) {
      if (this.msg) {
        final Graphics2D g2 = (Graphics2D) g;

        final int r = (int) (Math.random() * 250);
        final int gr = (int) (Math.random() * 250);
        final int b = (int) (Math.random() * 250);

        g.setColor(new Color(r, gr, b));

        final int ht = (int) ((Math.random() * 120) + 10);
        final int width = (int) ((Math.random() * 120) + 10);
        final int x = (int) ((Math.random() * 40) + 10);
        final int y = (int) ((Math.random() * 40) + 10);

        g.fillRect(x, y, ht, width);
        this.msg = false;
      }
    }
  }
}

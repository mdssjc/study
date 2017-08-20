package com.github.mdssjc.beatbox;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.logging.Logger;

public class BeatBox {

  private final String[] instrumentNames;
  private final int[] instruments;
  private JPanel mainPanel;
  private List<JCheckBox> checkboxList;
  private Sequencer sequencer;
  private Sequence sequence;
  private Track track;
  private JFrame theFrame;

  public BeatBox() {
    this.instrumentNames = new String[]{"Bass Drum", "Closed Hi-Hat",
        "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
        "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
        "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
        "Open Hi Conga"};
    this.instruments = new int[]{35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
  }

  public static void main(final String[] args) {
    new BeatBox().buildGUI();
  }

  private void buildGUI() {
    this.theFrame = new JFrame("Cyber BeatBox");
    this.theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final BorderLayout layout = new BorderLayout();
    final JPanel background = new JPanel(layout);
    background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

    this.checkboxList = new ArrayList<>();
    final Box buttonBox = new Box(BoxLayout.Y_AXIS);

    final JButton start = new JButton("Start");
    start.addActionListener(a -> buildTrackAndStart());
    buttonBox.add(start);

    final JButton stop = new JButton("Stop");
    stop.addActionListener(a -> this.sequencer.stop());
    buttonBox.add(stop);

    final Function<Float, ActionListener> tempo = p -> ev -> {
      final float tempoFactor = this.sequencer.getTempoFactor();
      this.sequencer.setTempoFactor(tempoFactor * p);
    };

    final JButton upTempo = new JButton("Tempo Up");
    upTempo.addActionListener(tempo.apply(1.03F));
    buttonBox.add(upTempo);

    final JButton downTempo = new JButton("Tempo Down");
    downTempo.addActionListener(tempo.apply(0.97F));
    buttonBox.add(downTempo);

    final Box nameBox = new Box(BoxLayout.Y_AXIS);
    for (int i = 0; i < 16; i++) {
      nameBox.add(new Label(this.instrumentNames[i]));
    }

    background.add(BorderLayout.EAST, buttonBox);
    background.add(BorderLayout.WEST, nameBox);

    this.theFrame.getContentPane()
                 .add(background);

    final GridLayout grid = new GridLayout(16, 16);
    grid.setVgap(1);
    grid.setHgap(2);
    this.mainPanel = new JPanel(grid);
    background.add(BorderLayout.CENTER, this.mainPanel);

    for (int i = 0; i < 256; i++) {
      final JCheckBox c = new JCheckBox();
      c.setSelected(false);
      this.checkboxList.add(c);
      this.mainPanel.add(c);
    }

    setUpMidi();

    this.theFrame.setBounds(50, 50, 300, 300);
    this.theFrame.pack();
    this.theFrame.setVisible(true);
  }

  private void setUpMidi() {
    try {
      this.sequencer = MidiSystem.getSequencer();
      this.sequencer.open();
      this.sequence = new Sequence(Sequence.PPQ, 4);
      this.track = this.sequence.createTrack();
      this.sequencer.setTempoInBPM(120.0F);
    } catch (final Exception e) {
      Logger.getGlobal()
            .info(e.getMessage());
    }
  }

  private void buildTrackAndStart() {
    int[] trackList;

    this.sequence.deleteTrack(this.track);
    this.track = this.sequence.createTrack();

    for (int i = 0; i < 16; i++) {
      trackList = new int[16];

      final int key = this.instruments[i];

      for (int j = 0; j < 16; j++) {
        final JCheckBox jc = this.checkboxList.get(j + (16 * i));
        if (jc.isSelected()) {
          trackList[j] = key;
        } else {
          trackList[j] = 0;
        }
      }

      makeTracks(trackList);
      this.track.add(makeEvent(176, 1, 127, 0, 16));
    }

    this.track.add(makeEvent(192, 9, 1, 0, 15));
    try {
      this.sequencer.setSequence(this.sequence);
      this.sequencer.setLoopCount(this.sequencer.LOOP_CONTINUOUSLY);
      this.sequencer.start();
      this.sequencer.setTempoInBPM(120.0F);
    } catch (final Exception e) {
      Logger.getGlobal()
            .info(e.getMessage());
    }
  }

  private void makeTracks(final int[] list) {
    for (int i = 0; i < 16; i++) {
      final int key = list[i];

      if (key != 0) {
        this.track.add(makeEvent(144, 9, key, 100, i));
        this.track.add(makeEvent(128, 9, key, 100, i + 1));
      }
    }
  }

  private MidiEvent makeEvent(final int comd, final int chan, final int one, final int two, final int tick) {
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

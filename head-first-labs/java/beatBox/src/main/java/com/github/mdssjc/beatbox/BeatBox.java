package com.github.mdssjc.beatbox;

import com.github.mdssjc.beatbox.events.*;
import lombok.Getter;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.*;
import java.util.List;
import java.util.logging.Logger;

public class BeatBox {

  private JFrame theFrame;
  private JPanel mainPanel;
  @Getter
  private JList incomingList;
  @Getter
  private JTextField userMessage;
  @Getter
  private List<JCheckBox> checkboxList;
  @Getter
  private int nextNum;
  @Getter
  private final Vector<String> listVector;
  @Getter
  private String userName;
  @Getter
  private ObjectOutputStream out;
  @Getter
  private ObjectInputStream in;
  @Getter
  private final Map<String, boolean[]> otherSeqsMap;

  @Getter
  private Sequencer sequencer;
  private Sequence sequence;
  private Track track;

  private final String[] instrumentNames;
  private final int[] instruments;

  public BeatBox() {
    this.listVector = new Vector<>();
    this.otherSeqsMap = new HashMap<>();
    this.instrumentNames = new String[]{"Bass Drum", "Closed Hi-Hat",
        "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
        "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
        "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
        "Open Hi Conga"};
    this.instruments = new int[]{35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};
  }

  public static void main(final String[] args) {
    new BeatBox().startUp(args[0]);
  }

  private void startUp(final String name) {
    this.userName = name;

    try {
      final Socket sock = new Socket("127.0.0.1", 4242);
      this.out = new ObjectOutputStream(sock.getOutputStream());
      this.in = new ObjectInputStream(sock.getInputStream());
      final Thread remote = new Thread(new RemoteReader(this));
      remote.start();
    } catch (final IOException ex) {
      Logger.getGlobal()
            .severe("Couldn’t connect - you’ll have to play alone.");
    }

    setUpMidi();
    buildGUI();
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
    start.addActionListener(new MyStartListener(this));
    buttonBox.add(start);

    final JButton stop = new JButton("Stop");
    stop.addActionListener(new MyStopListener(this));
    buttonBox.add(stop);

    final JButton upTempo = new JButton("Tempo Up");
    upTempo.addActionListener(new MyUpTempoListener(this));
    buttonBox.add(upTempo);

    final JButton downTempo = new JButton("Tempo Down");
    downTempo.addActionListener(new MyDownTempoListener(this));
    buttonBox.add(downTempo);

    final JButton serializeIt = new JButton("Serialize It");
    serializeIt.addActionListener(new MySendListenerLocal(this));
    buttonBox.add(serializeIt);

    final JButton restore = new JButton("Restore");
    restore.addActionListener(new MyReadInListenerLocal(this));
    buttonBox.add(restore);

    final JButton sendIt = new JButton("sendIt");
    sendIt.addActionListener(new MySendListenerChat(this));
    buttonBox.add(sendIt);

    this.userMessage = new JTextField();
    buttonBox.add(this.userMessage);

    this.incomingList = new JList();
    this.incomingList.addListSelectionListener(new MyListSelectionListener(this));
    this.incomingList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    final JScrollPane theList = new JScrollPane(this.incomingList);
    buttonBox.add(theList);
    this.incomingList.setListData(this.listVector);

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
    } catch (final Exception ex) {
      Logger.getGlobal()
            .severe(ex.getMessage());
    }
  }

  public void buildTrackAndStart() {
    List<Integer> trackList;
    this.sequence.deleteTrack(this.track);
    this.track = this.sequence.createTrack();

    for (int i = 0; i < 16; i++) {
      trackList = new ArrayList<>();
      for (int j = 0; j < 16; j++) {
        final JCheckBox jc = this.checkboxList.get(j + (16 * i));
        if (jc.isSelected()) {
          final int key = this.instruments[i];
          trackList.add(new Integer(key));
        } else {
          trackList.add(null);
        }
      }
      makeTracks(trackList);
    }

    this.track.add(makeEvent(192, 9, 1, 0, 15));

    try {
      this.sequencer.setSequence(this.sequence);
      this.sequencer.setLoopCount(this.sequencer.LOOP_CONTINUOUSLY);
      this.sequencer.start();
      this.sequencer.setTempoInBPM(120.0F);
    } catch (final Exception ex) {
      Logger.getGlobal()
            .severe(ex.getMessage());
    }
  }

  public void changeSequence(final boolean[] checkboxState) {
    for (int i = 0; i < 256; i++) {
      final JCheckBox check = this.checkboxList.get(i);
      check.setSelected(checkboxState[i]);
    }
  }

  private void makeTracks(final List<Integer> list) {
    final Iterator<Integer> it = list.iterator();
    for (int i = 0; i < 16; i++) {
      final Integer num = it.next();
      if (num != null) {
        final int numKey = num.intValue();
        this.track.add(makeEvent(144, 9, numKey, 100, i));
        this.track.add(makeEvent(128, 9, numKey, 100, i + 1));
      }
    }
  }

  private MidiEvent makeEvent(final int comd, final int chan, final int one, final int two, final int tick) {
    MidiEvent event = null;
    try {
      final ShortMessage a = new ShortMessage();
      a.setMessage(comd, chan, one, two);
      event = new MidiEvent(a, tick);
    } catch (final Exception ex) {
      Logger.getGlobal()
            .severe(ex.getMessage());
    }
    return event;
  }

  public int incNextNum() {
    return this.nextNum++;
  }
}

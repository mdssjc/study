package com.github.mdssjc.djview;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class BeatModel implements BeatModelInterface, MetaEventListener {

  private final List<BeatObserver> beatObservers;
  private final List<BPMObserver> bpmObservers;
  private Sequence sequence;
  private Track track;
  private Sequencer sequencer;
  private int bpm;

  public BeatModel() {
    this.beatObservers = new ArrayList<>();
    this.bpmObservers = new ArrayList<>();
    this.bpm = 90;
  }

  @Override
  public void initialize() {
    setUpMidi();
    buildTrackAndStart();
  }

  @Override
  public void on() {
    this.sequencer.start();
    setBPM(90);
  }

  @Override
  public void off() {
    setBPM(0);
    this.sequencer.stop();
  }

  @Override
  public int getBPM() {
    return this.bpm;
  }

  @Override
  public void setBPM(final int bpm) {
    this.bpm = bpm;
    this.sequencer.setTempoInBPM(getBPM());
    notifyBPMObservers();
  }

  public void beatEvent() {
    notifyBeatObservers();
  }

  @Override
  public void registerObserver(final BeatObserver o) {
    this.beatObservers.add(o);
  }

  public void notifyBeatObservers() {
    for (final BeatObserver observer : this.beatObservers) {
      observer.updateBeat();
    }
  }

  @Override
  public void removeObserver(final BeatObserver o) {
    final int i = this.beatObservers.indexOf(o);
    if (i >= 0) {
      this.beatObservers.remove(i);
    }
  }

  @Override
  public void registerObserver(final BPMObserver o) {
    this.bpmObservers.add(o);
  }

  public void notifyBPMObservers() {
    for (final BPMObserver observer : this.bpmObservers) {
      observer.updateBPM();
    }
  }

  @Override
  public void removeObserver(final BPMObserver o) {
    final int i = this.bpmObservers.indexOf(o);
    if (i >= 0) {
      this.bpmObservers.remove(i);
    }
  }

  @Override
  public void meta(final MetaMessage message) {
    if (message.getType() == 47) {
      beatEvent();
      this.sequencer.start();
      setBPM(getBPM());
    }
  }

  public void setUpMidi() {
    try {
      this.sequencer = MidiSystem.getSequencer();
      this.sequencer.open();
      this.sequencer.addMetaEventListener(this);
      this.sequence = new Sequence(Sequence.PPQ, 4);
      this.track = this.sequence.createTrack();
      this.sequencer.setTempoInBPM(getBPM());
    } catch (final Exception e) {
      Logger.getGlobal()
            .info(e.getMessage());
    }
  }

  public void buildTrackAndStart() {
    final int[] trackList = {35, 0, 46, 0};

    this.sequence.deleteTrack(null);
    this.track = this.sequence.createTrack();

    makeTracks(trackList);
    this.track.add(makeEvent(192, 9, 1, 0, 4));
    try {
      this.sequencer.setSequence(this.sequence);
    } catch (final Exception e) {
      Logger.getGlobal()
            .info(e.getMessage());
    }
  }

  public void makeTracks(final int[] list) {
    for (int i = 0; i < list.length; i++) {
      final int key = list[i];

      if (key != 0) {
        this.track.add(makeEvent(144, 9, key, 100, i));
        this.track.add(makeEvent(128, 9, key, 100, i + 1));
      }
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
}

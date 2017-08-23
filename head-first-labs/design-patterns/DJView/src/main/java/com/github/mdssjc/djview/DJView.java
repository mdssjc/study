package com.github.mdssjc.djview;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DJView implements ActionListener, BeatObserver, BPMObserver {

  private final BeatModelInterface model;
  private final ControllerInterface controller;
  private JFrame viewFrame;
  private JPanel viewPanel;
  private BeatBar beatBar;
  private JLabel bpmOutputLabel;
  private JLabel bpmLabel;
  private JTextField bpmTextField;
  private JButton setBPMButton;
  private JButton increaseBPMButton;
  private JButton decreaseBPMButton;
  private JMenuBar menuBar;
  private JMenu menu;
  private JMenuItem startMenuItem;
  private JMenuItem stopMenuItem;

  public DJView(final ControllerInterface controller, final BeatModelInterface model) {
    this.controller = controller;
    this.model = model;
    model.registerObserver((BeatObserver) this);
    model.registerObserver((BPMObserver) this);
  }

  public void createView() {
    // Create all Swing components here
  }

  public void createControls() {
    // Create all Swing components here
  }

  public void enableStopMenuItem() {
    this.stopMenuItem.setEnabled(true);
  }

  public void disableStopMenuItem() {
    this.stopMenuItem.setEnabled(false);
  }

  public void enableStartMenuItem() {
    this.startMenuItem.setEnabled(true);
  }

  public void disableStartMenuItem() {
    this.startMenuItem.setEnabled(false);
  }

  public void updateBPM() {
    final int bpm = this.model.getBPM();
    if (bpm == 0) {
      this.bpmOutputLabel.setText("offline");
    } else {
      this.bpmOutputLabel.setText("Current BPM: " + this.model.getBPM());
    }
  }

  public void updateBeat() {
    this.beatBar.setValue(100);
  }

  @Override
  public void actionPerformed(final ActionEvent event) {
    if (event.getSource() == this.setBPMButton) {
      final int bpm = Integer.parseInt(this.bpmTextField.getText());
      this.controller.setBPM(bpm);
    } else if (event.getSource() == this.increaseBPMButton) {
      this.controller.increaseBPM();
    } else if (event.getSource() == this.decreaseBPMButton) {
      this.controller.decreaseBPM();
    }
  }
}

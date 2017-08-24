package com.github.mdssjc.djview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DJView implements ActionListener, BeatObserver, BPMObserver {

  private final BeatModelInterface model;
  private final ControllerInterface controller;
  private JFrame viewFrame;
  private JPanel viewPanel;
  private BeatBar beatBar;
  private JLabel bpmOutputLabel;
  private JFrame controlFrame;
  private JPanel controlPanel;
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
    this.viewPanel = new JPanel(new GridLayout(1, 2));
    this.viewFrame = new JFrame("View");
    this.viewFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.viewFrame.setSize(new Dimension(100, 80));
    this.bpmOutputLabel = new JLabel("offline", SwingConstants.CENTER);
    this.beatBar = new BeatBar();
    this.beatBar.setValue(0);
    final JPanel bpmPanel = new JPanel(new GridLayout(2, 1));
    bpmPanel.add(this.beatBar);
    bpmPanel.add(this.bpmOutputLabel);
    this.viewPanel.add(bpmPanel);
    this.viewFrame.getContentPane()
                  .add(this.viewPanel, BorderLayout.CENTER);
    this.viewFrame.pack();
    this.viewFrame.setVisible(true);
  }

  public void createControls() {
    // Create all Swing components here
    JFrame.setDefaultLookAndFeelDecorated(true);
    this.controlFrame = new JFrame("Control");
    this.controlFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.controlFrame.setSize(new Dimension(100, 80));

    this.controlPanel = new JPanel(new GridLayout(1, 2));

    this.menuBar = new JMenuBar();
    this.menu = new JMenu("DJ Control");
    this.startMenuItem = new JMenuItem("Start");
    this.menu.add(this.startMenuItem);
    this.startMenuItem.addActionListener(event -> this.controller.start());
    this.stopMenuItem = new JMenuItem("Stop");
    this.menu.add(this.stopMenuItem);
    this.stopMenuItem.addActionListener(event -> this.controller.stop());
    final JMenuItem exit = new JMenuItem("Quit");
    exit.addActionListener(event -> System.exit(0));

    this.menu.add(exit);
    this.menuBar.add(this.menu);
    this.controlFrame.setJMenuBar(this.menuBar);

    this.bpmTextField = new JTextField(2);
    this.bpmLabel = new JLabel("Enter BPM:", SwingConstants.RIGHT);
    this.setBPMButton = new JButton("Set");
    this.setBPMButton.setSize(new Dimension(10, 40));
    this.increaseBPMButton = new JButton(">>");
    this.decreaseBPMButton = new JButton("<<");
    this.setBPMButton.addActionListener(this);
    this.increaseBPMButton.addActionListener(this);
    this.decreaseBPMButton.addActionListener(this);

    final JPanel buttonPanel = new JPanel(new GridLayout(1, 2));

    buttonPanel.add(this.decreaseBPMButton);
    buttonPanel.add(this.increaseBPMButton);

    final JPanel enterPanel = new JPanel(new GridLayout(1, 2));
    enterPanel.add(this.bpmLabel);
    enterPanel.add(this.bpmTextField);
    final JPanel insideControlPanel = new JPanel(new GridLayout(3, 1));
    insideControlPanel.add(enterPanel);
    insideControlPanel.add(this.setBPMButton);
    insideControlPanel.add(buttonPanel);
    this.controlPanel.add(insideControlPanel);

    this.bpmLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    this.bpmOutputLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

    this.controlFrame.getRootPane()
                     .setDefaultButton(this.setBPMButton);
    this.controlFrame.getContentPane()
                     .add(this.controlPanel, BorderLayout.CENTER);

    this.controlFrame.pack();
    this.controlFrame.setVisible(true);
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
    if (this.model != null) {
      final int bpm = this.model.getBPM();
      if (bpm == 0) {
        if (this.bpmOutputLabel != null) {
          this.bpmOutputLabel.setText("offline");
        }
      } else {
        if (this.bpmOutputLabel != null) {
          this.bpmOutputLabel.setText("Current BPM: " + this.model.getBPM());
        }
      }
    }
  }

  public void updateBeat() {
    if (this.beatBar != null) {
      this.beatBar.setValue(100);
    }
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

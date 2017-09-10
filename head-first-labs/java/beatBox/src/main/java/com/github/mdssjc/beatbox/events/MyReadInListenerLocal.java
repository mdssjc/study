package com.github.mdssjc.beatbox.events;

import com.github.mdssjc.beatbox.BeatBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.logging.Logger;

public class MyReadInListenerLocal implements ActionListener {

  private final BeatBox beatBox;

  public MyReadInListenerLocal(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    boolean[] checkboxState = null;

    try {
      FileInputStream fileIn = new FileInputStream(new File("Checkbox.ser"));
      ObjectInputStream is = new ObjectInputStream(fileIn);
      checkboxState = (boolean[]) is.readObject();
    } catch (Exception ex) {
      Logger.getGlobal()
            .severe(ex.getMessage());
    }

    for (int i = 0; i < 256; i++) {
      JCheckBox check = beatBox.getCheckboxList()
                               .get(i);
      if (checkboxState[i]) {
        check.setSelected(true);
      } else {
        check.setSelected(false);
      }
    }

    beatBox.getSequencer()
           .stop();
    beatBox.buildTrackAndStart();
  }
}

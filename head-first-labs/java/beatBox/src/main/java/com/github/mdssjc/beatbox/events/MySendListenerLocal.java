package com.github.mdssjc.beatbox.events;

import com.github.mdssjc.beatbox.BeatBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

public class MySendListenerLocal implements ActionListener {

  private final BeatBox beatBox;

  public MySendListenerLocal(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    boolean[] checkboxState = new boolean[256];

    for (int i = 0; i < 256; i++) {
      JCheckBox check = beatBox.getCheckboxList()
                               .get(i);
      if (check.isSelected()) {
        checkboxState[i] = true;
      }
    }

    try {
      FileOutputStream fileStream = new FileOutputStream(
          new File("Checkbox.ser"));
      ObjectOutputStream os = new ObjectOutputStream(fileStream);
      os.writeObject(checkboxState);
    } catch (Exception ex) {
      Logger.getGlobal()
            .severe(ex.getMessage());
    }
  }
}

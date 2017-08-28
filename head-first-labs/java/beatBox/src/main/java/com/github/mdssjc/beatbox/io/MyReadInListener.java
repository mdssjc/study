package com.github.mdssjc.beatbox.io;

import com.github.mdssjc.beatbox.BeatBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.logging.Logger;

public class MyReadInListener implements ActionListener {

  private final BeatBox beatBox;

  public MyReadInListener(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    boolean[] checkboxState;

    try {
      final FileInputStream fileIn = new FileInputStream(new File("Checkbox.ser"));
      final ObjectInputStream is = new ObjectInputStream(fileIn);
      checkboxState = (boolean[]) is.readObject();
    } catch (final Exception ex) {
      Logger.getGlobal()
            .info(ex.getMessage());
    }

    this.beatBox.setInstruments(checkboxState);
  }
}

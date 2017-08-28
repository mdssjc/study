package com.github.mdssjc.beatbox.io;

import com.github.mdssjc.beatbox.BeatBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Logger;

public class MySendListener implements ActionListener {

  private final BeatBox beatBox;

  public MySendListener(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    final boolean[] checkboxState = this.beatBox.readInstruments();

    try {
      final FileOutputStream fileStream = new FileOutputStream(
          new File("Checkbox.ser"));
      final ObjectOutputStream os = new ObjectOutputStream(fileStream);
      os.writeObject(checkboxState);
    } catch (final Exception ex) {
      Logger.getGlobal()
            .info(ex.getMessage());
    }
  }
}

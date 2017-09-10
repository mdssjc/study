package com.github.mdssjc.beatbox.events;

import com.github.mdssjc.beatbox.BeatBox;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;

public class MySendListenerChat implements ActionListener {

  private static final String MESSAGE_ERROR = "Sorry dude. Could not send it to the server.";
  private final BeatBox beatBox;

  public MySendListenerChat(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  @Override
  public void actionPerformed(final ActionEvent e) {
    final boolean[] checkboxState = new boolean[256];

    for (int i = 0; i < 256; i++) {
      final JCheckBox check = this.beatBox.getCheckboxList()
                                          .get(i);
      if (check.isSelected()) {
        checkboxState[i] = true;
      }
    }

    try {
      this.beatBox.getOut()
                  .writeObject(
                      this.beatBox.getUserName() +
                      this.beatBox.incNextNum() +
                      ": " + this.beatBox.getUserMessage()
                                         .getText());
      this.beatBox.getOut()
                  .writeObject(checkboxState);
    } catch (final Exception ex) {
      System.out.println(MESSAGE_ERROR);
      Logger.getGlobal()
            .severe(MESSAGE_ERROR);
    }
    this.beatBox.getUserMessage()
                .setText("");
  }
}

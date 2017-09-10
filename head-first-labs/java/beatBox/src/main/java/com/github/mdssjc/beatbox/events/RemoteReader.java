package com.github.mdssjc.beatbox.events;

import com.github.mdssjc.beatbox.BeatBox;

import java.util.logging.Logger;

public class RemoteReader implements Runnable {

  private final BeatBox beatBox;
  private boolean[] checkboxState;
  private Object obj;

  public RemoteReader(final BeatBox beatBox) {
    this.beatBox = beatBox;
  }

  public void run() {
    try {
      while ((this.obj = this.beatBox.getIn()
                                     .readObject()) != null) {
        System.out.println("got an object from server");
        System.out.println(this.obj.getClass());
        final String nameToShow = (String) this.obj;
        this.checkboxState = (boolean[]) this.beatBox.getIn()
                                                     .readObject();
        this.beatBox.getOtherSeqsMap()
                    .put(nameToShow, this.checkboxState);
        this.beatBox.getListVector()
                    .add(nameToShow);
        this.beatBox.getIncomingList()
                    .setListData(this.beatBox.getListVector());
      }
    } catch (final Exception ex) {
      Logger.getGlobal()
            .severe(ex.getMessage());
    }
  }
}

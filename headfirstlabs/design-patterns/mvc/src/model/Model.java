package model;

import java.util.Observable;

public class Model extends Observable {

  private final String[] messages = {
      "Message 1",
      "Message 2",
      "Message 3",
      "Message 4",
      "Message 5",
  };
  private int            cursor   = -1;

  public void nextMessage() {
    if (++this.cursor > this.messages.length) {
      this.cursor--;
    } else {
      setChanged();
      notifyObservers();
    }
  }

  public void prevMessage() {
    if (--this.cursor < 0) {
      this.cursor = 0;
    } else {
      setChanged();
      notifyObservers();
    }
  }

  public String getMessage() {
    return this.messages[this.cursor];
  }
}

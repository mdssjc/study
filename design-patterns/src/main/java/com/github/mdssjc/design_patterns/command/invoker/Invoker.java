package com.github.mdssjc.design_patterns.command.invoker;

import com.github.mdssjc.design_patterns.command.Command;

public class Invoker {

  private Command command;

  public Invoker() {
    // TODO
    //this.command = new NullObjectCommand();
  }

  public void setCommand(Command command) {
    this.command = command;
  }

  public void play() {
    this.command.execute();
  }

  public void reverse() {
    this.command.undo();
  }
}

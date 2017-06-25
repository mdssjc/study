package com.github.mdssjc.remote;

public class HottubOnCommand implements Command {

  private final Hottub hottub;

  public HottubOnCommand(final Hottub hottub) {
    this.hottub = hottub;
  }

  @Override
  public void execute() {
    this.hottub.on();
  }

  @Override
  public void undo() {
    this.hottub.off();
  }
}

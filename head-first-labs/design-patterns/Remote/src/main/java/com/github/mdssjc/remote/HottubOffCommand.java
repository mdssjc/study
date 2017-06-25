package com.github.mdssjc.remote;

public class HottubOffCommand implements Command {

  private final Hottub hottub;

  public HottubOffCommand(final Hottub hottub) {
    this.hottub = hottub;
  }

  @Override
  public void execute() {
    this.hottub.off();
  }

  @Override
  public void undo() {
    this.hottub.on();
  }
}

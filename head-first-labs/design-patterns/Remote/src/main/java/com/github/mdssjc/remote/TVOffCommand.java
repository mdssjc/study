package com.github.mdssjc.remote;

public class TVOffCommand implements Command {

  private final TV tv;

  public TVOffCommand(final TV tv) {
    this.tv = tv;
  }

  @Override
  public void execute() {
    this.tv.off();
  }

  @Override
  public void undo() {
    this.tv.on();
  }
}

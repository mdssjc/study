package com.github.mdssjc.remote;

public interface Command {

  void execute();

  void undo();
}

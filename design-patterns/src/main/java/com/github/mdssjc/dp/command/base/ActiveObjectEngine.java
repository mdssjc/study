package com.github.mdssjc.dp.command.base;

import com.github.mdssjc.dp.command.Command;

import java.util.LinkedList;
import java.util.List;

/**
 * Classe Active Object Engine.
 *
 * @author Marcelo dos Santos
 *
 */
public class ActiveObjectEngine {

  private final List<Command> itsCommands;

  public ActiveObjectEngine() {
    this.itsCommands = new LinkedList<>();
  }

  public void add(final Command c) {
    this.itsCommands.add(c);
  }

  public void run() {
    while (!this.itsCommands.isEmpty()) {
      final Command c = this.itsCommands.get(0);
      this.itsCommands.remove(0);
      c.execute();
    }
  }
}

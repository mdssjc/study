package com.github.mdssjc.dp.command.concrete;

import com.github.mdssjc.dp.command.Command;
import com.github.mdssjc.dp.command.base.ActiveObjectEngine;

/**
 * Classe Sleep Command.
 * <p>
 * Implementação do comando.
 *
 * @author Marcelo dos Santos
 *
 */
public class SleepCommand implements Command {

  private final Command wakeup;
  private final ActiveObjectEngine engine;
  private final long sleepTime;
  private long startTime;
  private boolean started;

  public SleepCommand(final long milliseconds, final ActiveObjectEngine e, final Command wakeup) {
    this.sleepTime = milliseconds;
    this.engine = e;
    this.wakeup = wakeup;
  }

  @Override
  public void execute() {
    final long currentTime = System.currentTimeMillis();
    if (!this.started) {
      this.started = true;
      this.startTime = currentTime;
      this.engine.add(this);
    } else if ((currentTime - this.startTime) < this.sleepTime) {
      this.engine.add(this);
    } else {
      this.engine.add(this.wakeup);
    }
  }

  @Override
  public void undo() {
  }

  @Override
  public void store() {
  }

  @Override
  public void load() {
  }
}

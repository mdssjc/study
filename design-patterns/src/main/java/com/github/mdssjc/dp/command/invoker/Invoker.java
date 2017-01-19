package com.github.mdssjc.dp.command.invoker;

import com.github.mdssjc.dp.command.Command;
import com.github.mdssjc.dp.command.concrete.NullObjectCommand;

/**
 * Classe Invoker.
 * <p>
 * Executa os comandos em seu contexto.
 *
 * @author Marcelo dos Santos
 *
 */
public class Invoker {

  private Command command;

  public Invoker() {
    this.command = new NullObjectCommand();
  }

  public void setCommand(final Command command) {
    this.command = command;
  }

  public void play() {
    this.command.execute();
  }

  public void reverse() {
    this.command.undo();
  }
}

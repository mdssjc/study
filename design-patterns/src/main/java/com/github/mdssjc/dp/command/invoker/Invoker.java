package com.github.mdssjc.dp.command.invoker;

import com.github.mdssjc.dp.command.Command;

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
    // TODO
    // this.command = new NullObjectCommand();
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

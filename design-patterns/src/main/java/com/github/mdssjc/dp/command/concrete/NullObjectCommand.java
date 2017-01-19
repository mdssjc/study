package com.github.mdssjc.dp.command.concrete;

import com.github.mdssjc.dp.command.Command;

/**
 * Classe Null Object Command.
 * <p>
 * Implementação do comando.
 *
 * @author Marcelo dos Santos
 *
 */
public class NullObjectCommand implements Command {

  @Override
  public void execute() {
    System.out.println("--");
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

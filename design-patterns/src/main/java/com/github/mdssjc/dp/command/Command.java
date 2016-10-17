package com.github.mdssjc.dp.command;

/**
 * Interface Command.
 * 
 * - execute:
 * - undo:
 * - store:
 * - load:
 *
 * @author Marcelo dos Santos
 *
 */
public interface Command {

  void execute();

  void undo();

  void store();

  void load();
}

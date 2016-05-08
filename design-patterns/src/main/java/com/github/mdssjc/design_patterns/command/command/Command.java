package com.github.mdssjc.design_patterns.command.command;

/**
 * Interface Command.
 * </p>
 * - execute:
 * - undo:
 * - store:
 * - load:
 *
 * @author mdssjc &lt;Marcelo dos Santos&gt;
 *
 */
public interface Command {

  void execute();

  void undo();

  void store();

  void load();
}

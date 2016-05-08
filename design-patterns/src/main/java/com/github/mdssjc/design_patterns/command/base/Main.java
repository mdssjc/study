package com.github.mdssjc.design_patterns.command.base;

import com.github.mdssjc.design_patterns.command.command.Command;
import com.github.mdssjc.design_patterns.command.command.concrete.ConcreteCommand;
import com.github.mdssjc.design_patterns.command.receiver.Receiver;

/**
 * Test drive do padrão de projeto Command.
 * </p>
 * Design Pattern
 * Behavioral - Command (Action, Transaction)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    // TODO aplicação exemplo
    // final Invoker invoker = new Invoker();

    final Receiver receiver = new Receiver();

    final Command command = new ConcreteCommand(receiver);

    // invoker.setCommand(command);

    // invoker.play();
    // invoker.reverse();
  }
}

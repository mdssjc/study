package com.github.mdssjc.design_patterns.command.base;

import com.github.mdssjc.design_patterns.command.Command;
import com.github.mdssjc.design_patterns.command.concrete.ConcreteCommand;
import com.github.mdssjc.design_patterns.command.invoker.Invoker;
import com.github.mdssjc.design_patterns.command.receiver.Receiver;

/**
 * Test drive do padrão de projeto Command.
 *
 * Design Pattern
 * Behavioral - Command (Action, Transaction)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Invoker invoker = new Invoker();
    final Receiver receiver = new Receiver();

    final Command command = new ConcreteCommand(receiver);

    invoker.setCommand(command);

    invoker.play();
    invoker.reverse();
  }
}

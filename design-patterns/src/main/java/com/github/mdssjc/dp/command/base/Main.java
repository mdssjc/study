package com.github.mdssjc.dp.command.base;

import com.github.mdssjc.dp.command.Command;
import com.github.mdssjc.dp.command.concrete.ConcreteCommand;
import com.github.mdssjc.dp.command.invoker.Invoker;
import com.github.mdssjc.dp.command.receiver.Receiver;

import java.util.ArrayList;

/**
 * Test drive do padrão de projeto Command.
 * <p>
 * Design Pattern
 * Behavioral - Command (Action, Transaction)
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    // Versão Clássica
    final Invoker invoker = new Invoker();
    final Receiver receiver = new Receiver();

    final Command command = new ConcreteCommand(receiver);

    invoker.setCommand(command);

    invoker.play();
    invoker.reverse();

    // Versão Funcional
    final ArrayList<Runnable> tasks = new ArrayList<>();
    tasks.add(() -> new Receiver().action());
    tasks.forEach(Runnable::run);
  }
}

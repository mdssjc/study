package com.github.mdssjc.dp.command.base;

import com.github.mdssjc.dp.command.Command;
import com.github.mdssjc.dp.command.concrete.ConcreteCommand;
import com.github.mdssjc.dp.command.concrete.SleepCommand;
import com.github.mdssjc.dp.command.invoker.Invoker;
import com.github.mdssjc.dp.command.receiver.Receiver;

import java.util.ArrayList;
import java.util.List;

/**
 * Test drive do padrão de projeto Command.
 * <p>
 * Design Pattern
 * Behavioral - Command (Action, Transaction)
 *
 * @author Marcelo dos Santos
 */
public class Main {

  public static void main(final String[] args) {
    // Versão Clássica
    System.out.println("Versão Clássica");
    final Invoker invoker = new Invoker();
    final Receiver receiver = new Receiver();

    final Command command = new ConcreteCommand(receiver);

    invoker.play();
    invoker.setCommand(command);

    invoker.play();
    invoker.reverse();

    // Versão Funcional
    System.out.println("Versão Funcional");
    final List<Runnable> tasks = new ArrayList<>();
    tasks.add(() -> {
      final Receiver r = new Receiver();
      r.action();
      System.out.println(r.getNumber());
    });
    tasks.forEach(Runnable::run);

    // Active Object Engine
    System.out.println("Active Object Engine");
    final ActiveObjectEngine engine = new ActiveObjectEngine();
    engine.add(command);
    engine.add(new SleepCommand(1000, engine, command));
    engine.run();
  }
}

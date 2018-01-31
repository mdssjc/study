package com.github.mdssjc.design_patterns.behavioral.command;

/**
 * Padrão de projeto: Command.
 * <p>
 * Design Pattern
 * Object Behavioral / Operations - Command (Action, Transaction)
 * <p>
 * O padrão Command encapsula uma solicitação como um objeto, desta forma
 * permitindo parametrizar clientes em diferentes solicitações, enfileira ou faz
 * registro (log) de solicitações e suporta operações que podem ser desfeitos.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Receiver receiver = new Receiver();
    final Command command = new ConcreteCommand(receiver);

    final Invoker invoker = new Invoker(command);
    System.out.println(invoker.message());
  }
}

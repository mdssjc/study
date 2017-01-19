package com.github.mdssjc.dp.command.concrete;

import com.github.mdssjc.dp.command.Command;
import com.github.mdssjc.dp.command.receiver.Receiver;

import java.util.Stack;

/**
 * Classe Command.
 * <p>
 * Implementação do comando.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteCommand implements Command {

  private final Receiver receiver;
  private final Stack<Integer> states;

  public ConcreteCommand(final Receiver receiver) {
    this.receiver = receiver;
    this.states = new Stack<>();
  }

  @Override
  public void execute() {
    this.receiver.action();
    final int number = this.receiver.getNumber();
    this.states.push(number);
    System.out.printf("Mensagem %d%n", number);
  }

  @Override
  public void undo() {
    System.out.printf("Mensagem %d%n", this.states.pop());
  }

  @Override
  public void store() {
  }

  @Override
  public void load() {
  }
}

package com.github.mdssjc.dp.command.receiver;

import java.util.Random;

/**
 * Classe Receiver.
 * <p>
 * Possui as funcionalidades abstraidas do sistema.
 *
 * @author Marcelo dos Santos
 *
 */
public class Receiver {

  private static final int BOUND = 10000;
  private final Random     random;

  public Receiver() {
    this.random = new Random();
  }

  public void message() {
    System.out.printf("Mensagem %d%n", this.random.nextInt(Receiver.BOUND));
  }
}

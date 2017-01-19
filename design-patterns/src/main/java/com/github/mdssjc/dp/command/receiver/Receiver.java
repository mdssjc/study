package com.github.mdssjc.dp.command.receiver;

import lombok.Getter;

import java.util.Random;

/**
 * Classe Receiver.
 * <p>
 * Possui as funcionalidades abstraídas do sistema.
 *
 * @author Marcelo dos Santos
 *
 */
public class Receiver {

  private static final int BOUND = 10000;
  private final Random random;
  @Getter
  private int number;

  public Receiver() {
    this.random = new Random();
  }

  public void action() {
    this.number = this.random.nextInt(Receiver.BOUND);
  }
}

package com.github.mdssjc.design_patterns.behavioral.memento;

/**
 * Padrão de projeto: Memento.
 * <p>
 * Design Pattern
 * Object Behavioral / Construction - Memento (Token)
 * <p>
 * O padrão Memento, sem violar o encapsulamento, captura e externaliza um
 * estado interno de um objeto, de maneiras que o objeto possa ser restaurado
 * para esse estado mais tarde.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Caretaker caretaker = new Caretaker(new Originator());

    for (int i = 0; i < 2; i++) {
      System.out.println(caretaker);
      caretaker.save();
    }

    for (int i = 0; i < 5; i++) {
      System.out.println(caretaker);
      caretaker.undo();
    }
  }
}

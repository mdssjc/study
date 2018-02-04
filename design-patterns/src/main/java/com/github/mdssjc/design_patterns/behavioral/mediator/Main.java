package com.github.mdssjc.design_patterns.behavioral.mediator;

/**
 * Padrão de projeto: Mediator.
 * <p>
 * Design Pattern
 * Object Behavioral / Responsibility - Mediator
 * <p>
 * O padrão Mediator define um objeto que encapsula a forma como um conjunto de
 * objetos interage. O Mediator promove o acomplamento fraco ao evitar que os
 * objetos se refiram uns aos outros explicitamente e permite variar suas
 * interações independentemente.
 * <p>
 * Ao cliente: impõe a política de baixo, invisível e habilitado
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Mediator mediator = new ConcreteMediator();
    mediator.createColleagues();

    for (int i = 0; i < 10; i++) {
      System.out.println(mediator.message());
    }
  }
}

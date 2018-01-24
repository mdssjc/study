package com.github.mdssjc.design_patterns.structural.facade;

/**
 * Padrão de projeto: Facade.
 * <p>
 * Design Pattern
 * Object Structural / Interfaces - Facade
 * <p>
 * O padrão Facade fornece uma interface unificada para um conjunto de
 * interfaces em um subsistema. Facade define uma interface de nível mais alto
 * que torna o subsistema mais fácil de ser usado.
 * <p>
 * Ao cliente: impõe a política de cima, visível e restringido
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Facade facade = new Facade();
    System.out.println(facade.message1());
    System.out.println(facade.message2());
    System.out.println(facade.message3());
  }
}

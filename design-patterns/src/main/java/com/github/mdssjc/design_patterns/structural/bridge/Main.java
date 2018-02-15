package com.github.mdssjc.design_patterns.structural.bridge;

/**
 * Padrão de projeto: Bridge.
 * <p>
 * Design Pattern
 * Object Structural / Interfaces - Builder (Handle/Body)
 * <p>
 * O padrão Bridge desacopla uma abstração da sua implementação, de modo que as
 * duas possam variar independentemente.
 * <p>
 * Abstração (Abstraction)        -> Interface.
 * Implementação (Implementation) -> Plataforma (Platform).
 * <p>
 * Conceitos: abstração/plataforma (abstraction/platform);
 *            domínio/infraestrutura (domain/infrastructure);
 *            front-end/back-end; ou
 *            interface/implementação (interface/implementation).
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Abstraction abstraction1 = new RefinedAbstraction(
        new ConcreteImplementorA());
    final Abstraction abstraction2 = new RefinedAbstraction(
        new ConcreteImplementorB());

    System.out.println(abstraction1.operation());
    System.out.println(abstraction2.operation());
  }
}

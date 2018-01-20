package com.github.mdssjc.design_patterns.creational.bridge;

/**
 * Padrão de projeto: Bridge.
 * <p>
 * Design Pattern
 * Object Structural / Interfaces - Builder (Handle/Body)
 * <p>
 * O padrão Bridge desacopla uma abstração da sua implementação, de modo que as
 * duas possam variar independentemente.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Abstraction abstraction1 = new RefinedAbstraction(new ConcreteImplementorA());
    final Abstraction abstraction2 = new RefinedAbstraction(new ConcreteImplementorB());

    System.out.println(abstraction1.operation());
    System.out.println(abstraction2.operation());
  }
}

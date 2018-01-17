package com.github.mdssjc.design_patterns.creational.prototype;

/**
 * Padrão de projeto: Prototype.
 * <p>
 * Design Pattern
 * Object Creational / Construction - Prototype
 * <p>
 * O padrão Prototype especifica os tipos de objetos a serem criados usando uma
 * instância-protótipo e cria novos objetos pela cópia desse protótipo.
 * <p>
 * Cria através de delegação.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Prototype prototype1 = new ConcretePrototype1();
    final Prototype prototype2 = new ConcretePrototype2();

    final Prototype prototype1a = prototype1.clone();
    final Prototype prototype1b = prototype1.clone();
    final Prototype prototype1c = prototype1.clone();

    final Prototype prototype2b = prototype2.clone();
    final Prototype prototype2c = prototype2.clone();
    final Prototype prototype2a = prototype2.clone();

    System.out.println(prototype1.message());
    System.out.println(prototype1a.message());
    System.out.println(prototype1b.message());
    System.out.println(prototype1c.message());

    System.out.println(prototype2.message());
    System.out.println(prototype2a.message());
    System.out.println(prototype2b.message());
    System.out.println(prototype2c.message());

    System.out.println(prototype1.hashCode());
    System.out.println(prototype1a.hashCode());
    System.out.println(prototype1b.hashCode());
    System.out.println(prototype1c.hashCode());
  }
}

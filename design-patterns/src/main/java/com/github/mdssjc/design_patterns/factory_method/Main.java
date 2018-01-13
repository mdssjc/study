package com.github.mdssjc.design_patterns.factory_method;

/**
 * Padrão de projeto: Factory Method.
 * <p>
 * Design Pattern
 * Class Creational / Construction - Factory Method (Virtual Constructor)
 * <p>
 * O padrão Factory Method define uma interface para criar um objeto, mas deixa
 * as subclasses decidirem que classe instanciar. O Factory Method permite adiar
 * a instanciação para subclasse.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Creator creator1 = new Creator() {
    };
    final Creator creator2 = new ConcreteCreator();

    final Product product1 = creator1.factoryMethod();
    final String message1 = product1.message();

    final Product product2 = creator2.factoryMethod();
    final String message2 = product2.message();

    System.out.println(message1);
    System.out.println(message2);
  }
}

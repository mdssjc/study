package com.github.mdssjc.design_patterns.creational.abstract_factory;

/**
 * Padrão de projeto: Abstract Factory.
 * <p>
 * Design Pattern
 * Object Creational / Construction - Abstract Factory (Kit)
 * <p>
 * O padrão Abstract Factory prove uma interface para criar uma família de
 * objetos relacionados ou dependentes sem especificar suas classes concretas.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final AbstractFactory factory1 = new ConcreteFactory1();
    final AbstractFactory factory2 = new ConcreteFactory2();

    AbstractProductA productA = factory1.createProdutA();
    AbstractProductB productB = factory1.createProdutB();
    productA.message();
    productB.message();

    productA = factory2.createProdutA();
    productB = factory2.createProdutB();
    productA.message();
    productB.message();
  }
}

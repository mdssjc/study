package com.github.mdssjc.design_patterns.structural.decorator;

/**
 * Padrão de projeto: Decorator.
 * <p>
 * Design Pattern
 * Object Structural / Extensions - Decorator (Wrapper)
 * <p>
 * O padrão Decorator anexa dinamicamente responsabilidades adicionais a um
 * objeto. Os Decorators fornecem uma alternativa flexível ao uso de subclasses
 * para extensão de funcionalidades.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Component concreteComponent = new ConcreteComponent();
    final Component concreteDecoratorA = new ConcreteDecoratorA(concreteComponent, " : ");
    final Component concreteDecoratorB = new ConcreteDecoratorB(concreteDecoratorA, 5);

    System.out.println(concreteDecoratorB.operation());
  }
}

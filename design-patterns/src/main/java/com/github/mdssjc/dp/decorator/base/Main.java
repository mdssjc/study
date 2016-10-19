package com.github.mdssjc.dp.decorator.base;

import com.github.mdssjc.dp.decorator.component.Component;
import com.github.mdssjc.dp.decorator.component.concrete.ConcreteComponent;
import com.github.mdssjc.dp.decorator.concrete.ConcreteDecoratorA;
import com.github.mdssjc.dp.decorator.concrete.ConcreteDecoratorB;
import com.github.mdssjc.dp.decorator.functional.FunctionalDecorator;

/**
 * Test drive do padrão de projeto ConcreteDecoratorA.
 * <p>
 * Design Pattern
 * Structural - ConcreteDecoratorA (Wrapper)
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    // Versão Clássica
    final Component component = new ConcreteDecoratorA(
        new ConcreteDecoratorB(
            new ConcreteComponent()));
    component.operation("Minha mensagem");


    // Versão Funcional
    System.out.println(new FunctionalDecorator()
        .andThen(FunctionalDecorator::tagA)
        .andThen(FunctionalDecorator::tagB)
        .apply("Minha mensagem"));
  }
}

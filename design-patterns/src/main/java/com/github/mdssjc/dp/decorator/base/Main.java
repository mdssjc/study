package com.github.mdssjc.dp.decorator.base;

import com.github.mdssjc.dp.decorator.component.Component;
import com.github.mdssjc.dp.decorator.component.concrete.ConcreteComponent;
import com.github.mdssjc.dp.decorator.concrete.ConcreteDecoratorA;
import com.github.mdssjc.dp.decorator.concrete.ConcreteDecoratorB;

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
//    final UnaryOperator<String> decorator = s -> s;
//
//    final String result = decorator
//        .andThen(s -> "--" + s + "--")
//        .andThen(s -> "$$" + s + "$$")
//        .apply(counter.text());
//    System.out.println(result);
  }
}

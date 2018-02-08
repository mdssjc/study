package com.github.mdssjc.design_patterns.behavioral.strategy;

/**
 * Padrão de projeto: Strategy.
 * <p>
 * Design Pattern
 * Object Behavioral / Operations - Strategy (Policy)
 * <p>
 * O padrão Strategy define uma família de algoritmos, encapsula cada uma delas
 * e torná-las intercambiáveis. Strategy permite que o algoritmo varie
 * independentemente dos clientes que o utilizam.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Context context = new Context();

    context.setStrategy(new ConcreteStrategyA());
    final String messageA = context.contextInterface();
    System.out.println(messageA);

    context.setStrategy(new ConcreteStrategyB());
    final String messageB = context.contextInterface();
    System.out.println(messageB);

    context.setStrategy( new ConcreteStrategyC());
    final String messageC = context.contextInterface();
    System.out.println(messageC);
  }
}

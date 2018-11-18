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
 * <p>
 * Uso do dialeto 'handle/body'.
 *
 * @author Marcelo dos Santos
 */
public class Main {

  public static void main(final String[] args) {
    final Context context = new Context();

    // Classic

    context.setStrategy(new ConcreteStrategyA());
    System.out.println(context.contextInterface());

    context.setStrategy(new ConcreteStrategyB());
    System.out.println(context.contextInterface());

    context.setStrategy(new ConcreteStrategyC());
    System.out.println(context.contextInterface());

    // Functional

    context.setStrategy(() -> "Concrete Strategy D");
    System.out.println(context.contextInterface());
  }
}

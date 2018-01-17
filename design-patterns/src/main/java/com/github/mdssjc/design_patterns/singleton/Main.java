package com.github.mdssjc.design_patterns.singleton;

/**
 * Padrão de projeto: Singleton.
 * <p>
 * Design Pattern
 * Object Creational / Construction - Singleton
 * <p>
 * O padrão Singleton garante que uma classe tenha somente uma instância e
 * forneça um ponto global de acesso para a mesma.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Singleton singleton = Singleton.instance();

    String message = singleton.getData();
    System.out.println(message);

    singleton.operation();
    message = singleton.getData();
    System.out.println(message);
  }
}

package com.github.mdssjc.design_patterns.creational.builder;

/**
 * Padrão de projeto: Builder.
 * <p>
 * Design Pattern
 * Object Creational / Construction - Builder
 * <p>
 * O padrão Builder separa a construção de um objeto complexo da sua
 * representação de modo que o mesmo processo de construção possa criar
 * diferentes representações.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Builder builder = new ConcreteBuilder();
    final Director director = new Director(builder);

    director.construct();
    final Product product = builder.getResult();

    product.message();
  }
}

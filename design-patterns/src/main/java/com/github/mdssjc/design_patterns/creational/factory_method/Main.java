package com.github.mdssjc.design_patterns.creational.factory_method;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Padrão de projeto: Factory Method.
 * <p>
 * Design Pattern
 * Class Creational / Construction - Factory Method (Virtual Constructor)
 * <p>
 * O padrão Factory Method define uma interface para criar um objeto, mas deixa
 * as subclasses decidirem que classe instanciar. O Factory Method permite adiar
 * a instanciação para subclasse.
 * <p>
 * Cria através de herança.
 *
 * @author Marcelo dos Santos
 */
public class Main {

  public static void main(final String[] args) {
    // Classic

    final Creator creator1 = new Creator() {
    };
    final Creator creator2 = new ConcreteCreator();

    final Product product1 = creator1.factoryMethod();
    final String message1 = product1.message();

    final Product product2 = creator2.factoryMethod();
    final String message2 = product2.message();

    System.out.println(message1);
    System.out.println(message2);

    // Functional

    final Map<String, Supplier<Product>> map = new HashMap();
    map.put("product", () -> new ConcreteProduct("Concrete Product"));

    final String message3 = map.get("product")
                               .get()
                               .message();

    System.out.println(message3);
  }
}

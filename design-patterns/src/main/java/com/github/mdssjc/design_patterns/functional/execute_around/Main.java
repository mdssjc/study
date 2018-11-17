package com.github.mdssjc.design_patterns.functional.execute_around;

/**
 * Padrão de projeto: Execute Around.
 *
 * @author Marcelo dos Santos
 */
public class Main {

  public static void main(final String[] args) {
    final Service service = new Service();

    service.execute(writer -> {
      writer.println("Hi!");
      writer.print("My name is ");
      writer.println("John");
    });
  }
}

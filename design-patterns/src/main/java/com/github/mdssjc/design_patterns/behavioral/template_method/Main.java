package com.github.mdssjc.design_patterns.behavioral.template_method;

/**
 * Padrão de projeto: Template Method.
 * <p>
 * Design Pattern
 * Class Behavioral / Operations - Template Method
 * <p>
 * O padrão Template Method define o esqueleto de um algoritmo em uma operação,
 * postergando alguns passos para as subclasses. Template Method permite que
 * subclasses redefinam certos passos de um algoritmo sem mudar a estrutura do
 * mesmo.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final AbstractClass abstractClass = new ConcreteClass();
    abstractClass.templateMethod();
  }
}

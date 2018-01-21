package com.github.mdssjc.design_patterns.structural.composite;

/**
 * Padrão de projeto: Composite.
 * <p>
 * Design Pattern
 * Object Structural / Interfaces - Composite
 * <p>
 * O padrão Composite compõe objetos em estruturas de árvore para representarem
 * hierarquias parte-todo. Composite permite aos clientes tratarem de maneira
 * uniforme objetos individuais e composições de objetos.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Component component = new Composite();
    final Composite composite = new Composite();

    component.add(new Leaf());
    component.add(composite);
    component.add(new Leaf());

    composite.add(new Leaf());

    component.operation();
  }
}

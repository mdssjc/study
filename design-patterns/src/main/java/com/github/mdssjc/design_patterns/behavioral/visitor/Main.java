package com.github.mdssjc.design_patterns.behavioral.visitor;

/**
 * Padrão de projeto: Visitor.
 * <p>
 * Design Pattern
 * Object Behavioral / Extensions - Visitor
 * <p>
 * O padrão Visitor representa uma operação a ser executada nos elementos de uma
 * estrutura de objetos. Visitor permite definir uma nova operação sem mudar as
 * classes dos elementos sobre os quais opera.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Visitor visitor1 = new ConcreteVisitor1();
    final Visitor visitor2 = new ConcreteVisitor2();

    final ObjectStructure structure = new ObjectStructure(
        new ConcreteElementA(), new ConcreteElementB());
    structure.execute(visitor1);
    structure.execute(visitor2);
  }
}

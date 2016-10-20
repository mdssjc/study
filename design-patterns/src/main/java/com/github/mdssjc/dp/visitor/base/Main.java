package com.github.mdssjc.dp.visitor.base;

import com.github.mdssjc.dp.visitor.Visitor;
import com.github.mdssjc.dp.visitor.concrete.ConcreteVisitor1;
import com.github.mdssjc.dp.visitor.concrete.ConcreteVisitor2;
import com.github.mdssjc.dp.visitor.element.Element;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementA;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementB;

import java.util.Arrays;
import java.util.List;

/**
 * Test drive do padrão de projeto Visitor.
 * <p>
 * Design Pattern
 * Behavioral - Visitor
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final List<Element> elements = Arrays.asList(new ConcreteElementA(), new ConcreteElementB());

    final Visitor visitor1 = new ConcreteVisitor1();
    final Visitor visitor2 = new ConcreteVisitor2();
    for (final Element element : elements) {
      System.out.println(element.accept(visitor1));
      System.out.println(element.accept(visitor2));
    }
  }
}

package com.github.mdssjc.dp.visitor.base;

import com.github.mdssjc.dp.visitor.Visitor;
import com.github.mdssjc.dp.visitor.acyclic.AVisitor;
import com.github.mdssjc.dp.visitor.acyclic.concrete.AConcreteVisitor1;
import com.github.mdssjc.dp.visitor.acyclic.concrete.AConcreteVisitor2;
import com.github.mdssjc.dp.visitor.acyclic.element.AElement;
import com.github.mdssjc.dp.visitor.acyclic.element.concrete.AConcreteElementA;
import com.github.mdssjc.dp.visitor.acyclic.element.concrete.AConcreteElementB;
import com.github.mdssjc.dp.visitor.concrete.ConcreteVisitor1;
import com.github.mdssjc.dp.visitor.concrete.ConcreteVisitor2;
import com.github.mdssjc.dp.visitor.element.Element;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementA;
import com.github.mdssjc.dp.visitor.element.concrete.ConcreteElementB;
import com.github.mdssjc.dp.visitor.functional.LambdaVisitor;

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
    // Versão Clássica
    final List<Element> elements = Arrays.asList(new ConcreteElementA(), new ConcreteElementB());

    final Visitor visitor1 = new ConcreteVisitor1();
    final Visitor visitor2 = new ConcreteVisitor2();
    for (final Element element : elements) {
      System.out.println(element.accept(visitor1));
      System.out.println(element.accept(visitor2));
    }

    // Versão Acíclica
    final List<AElement> aElements = Arrays.asList(new AConcreteElementA(), new AConcreteElementB());

    final AVisitor aVisitor1 = new AConcreteVisitor1();
    final AVisitor aVisitor2 = new AConcreteVisitor2();
    for (final AElement element : aElements) {
      System.out.println(element.accept(aVisitor1));
      System.out.println(element.accept(aVisitor2));
    }

    // Versão Funcional
    elements.stream()
            .map(LambdaVisitor.visitor1)
            .forEach(System.out::println);
    elements.stream()
            .map(LambdaVisitor.visitor2)
            .forEach(System.out::println);
  }
}

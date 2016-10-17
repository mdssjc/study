package com.github.mdssjc.dp.strategy.base;

import com.github.mdssjc.dp.strategy.concrete.AlgorithmA;
import com.github.mdssjc.dp.strategy.concrete.AlgorithmB;
import com.github.mdssjc.dp.strategy.concrete.AlgorithmC;
import com.github.mdssjc.dp.strategy.context.*;

/**
 * Test drive do padrão de projeto Strategy.
 * <p>
 * Design Pattern
 * Behavioral - Strategy (Policy)
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    // Versão Clássica
    final ImplementationX ca = new ImplementationA();
    final ImplementationX cb = new ImplementationB();
    final ImplementationX cc = new ImplementationC();

    System.out.println("<<Execution>>");
    ca.useAlgorithm();
    cb.useAlgorithm();
    cc.useAlgorithm();

    System.out.println("<<Change>>");
    ca.setAlgorithm(new AlgorithmB());
    ca.useAlgorithm();
    ca.setAlgorithm(new AlgorithmC());
    ca.useAlgorithm();
    ca.setAlgorithm(new AlgorithmA());
    ca.useAlgorithm();

    System.out.println("<<Null>>");
    final ImplementationX cnull = new ImplementationNull();
    cnull.useAlgorithm();

    // Versão Funcional
    final ImplementationA fca = new ImplementationA();

    System.out.println("<<Execution>>");
    fca.useAlgorithm();

    System.out.println("<<Change>>");
    fca.setAlgorithm(() -> System.out.println("Functional Algorithm A"));
    fca.useAlgorithm();
  }
}

package com.github.mdssjc.dp.strategy.base;

import com.github.mdssjc.dp.strategy.algorithms.concrete.AlgorithmA;
import com.github.mdssjc.dp.strategy.algorithms.concrete.AlgorithmB;
import com.github.mdssjc.dp.strategy.algorithms.concrete.AlgorithmC;
import com.github.mdssjc.dp.strategy.contexts.*;

/**
 * Test drive do padrão de projeto Strategy.
 * <p>
 * Design Pattern
 * Behavioral - Strategy
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(String[] args) {
    // Versão Clássica
    ImplementationX ca = new ImplementationA();
    ImplementationX cb = new ImplementationB();
    ImplementationX cc = new ImplementationC();

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
    ImplementationX cnull = new ImplementationNull();
    cnull.useAlgorithm();

    // Versão Funcional
    final ImplementationA fca = new ImplementationA();
    fca.useAlgorithm();
    fca.setAlgorithm(() -> System.out.println("Functional Algorithm A"));
    fca.useAlgorithm();
  }
}

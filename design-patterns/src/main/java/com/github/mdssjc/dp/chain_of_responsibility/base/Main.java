package com.github.mdssjc.dp.chain_of_responsibility.base;

import com.github.mdssjc.dp.chain_of_responsibility.functional.FunctionalHandler;
import com.github.mdssjc.dp.chain_of_responsibility.handler.Handler;
import com.github.mdssjc.dp.chain_of_responsibility.handler.concrete.ConcreteHandler1;
import com.github.mdssjc.dp.chain_of_responsibility.handler.concrete.ConcreteHandler2;

/**
 * Test drive do padrão de projeto Chain of Responsibility.
 * <p>
 * Design Pattern
 * Behavioral - Chain of Responsibility
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    // Versão Clássica
    final Handler handler1 = new ConcreteHandler1();
    final Handler handler2 = new ConcreteHandler2();

    handler1.nextSuccessor(handler2);

    handler1.handleRequest("Novo texto");
    handler1.handleRequest(123);
    try {
      handler1.handleRequest('a');
    } catch (final Exception e) {
      System.out.println("Erro capturado: " + e.getMessage());
    }

    // Versão Funcional
    final FunctionalHandler functionalHandler = new FunctionalHandler();
    functionalHandler.handleRequest("Novo texto");
    functionalHandler.handleRequest(123);
    try {
      functionalHandler.handleRequest('a');
    } catch (final Exception e) {
      System.out.println("Erro capturado: " + e.getMessage());
    }
  }
}

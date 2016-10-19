package com.github.mdssjc.dp.chain_of_responsibility.handler.concrete;

import com.github.mdssjc.dp.chain_of_responsibility.handler.Handler;

/**
 * Classe ConcreteHandler1.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteHandler1 extends Handler {

  @Override
  public void handleRequest(final Object message) {
    if (message instanceof String) {
      System.out.println("Mensagem textual: " + message);
    } else if (successor != null) {
      this.successor.handleRequest(message);
    } else {
      throw new RuntimeException("Fim da cadeia");
    }
  }
}

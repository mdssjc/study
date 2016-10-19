package com.github.mdssjc.dp.chain_of_responsibility.handler.concrete;

import com.github.mdssjc.dp.chain_of_responsibility.handler.Handler;

/**
 * Classe ConcreteHandler2.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteHandler2 extends Handler {

  @Override
  public void handleRequest(final Object message) {
    if (message instanceof Integer) {
      System.out.println("Mensagem numérica: " + String.valueOf(message));
    } else if (this.successor != null) {
      this.successor.handleRequest(message);
    } else {
      throw new RuntimeException("Fim da cadeia");
    }
  }
}

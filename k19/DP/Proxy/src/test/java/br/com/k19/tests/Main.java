package br.com.k19.tests;

import br.com.k19.proxy.ContaProxy;
import br.com.k19.subject.real.ContaPadrao;

/**
 * Design Pattern
 * Structural - Proxy (Surrogate)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final ContaPadrao contaPadrao = new ContaPadrao();
    final ContaProxy contaProxy = new ContaProxy(contaPadrao);
    contaProxy.deposita(100);
    contaProxy.saca(59);
    System.out.println("Saldo: " + contaProxy.getSaldo());
  }
}

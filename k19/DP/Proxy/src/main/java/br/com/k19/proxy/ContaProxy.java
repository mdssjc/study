package br.com.k19.proxy;

import br.com.k19.subject.Conta;

/**
 * Proxy Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class ContaProxy implements Conta {

  private final Conta conta;

  public ContaProxy(final Conta conta) {
    this.conta = conta;
  }

  @Override
  public void deposita(final double valor) {
    System.out.println("Efetuando o depósito de R$ " + valor + "...");
    this.conta.deposita(valor);
    System.out.println("Depósito de R$ " + valor + " efetuado...");
  }

  @Override
  public void saca(final double valor) {
    System.out.println("Efetuando o saque de R$ " + valor);
    this.conta.saca(valor);
    System.out.println("Saque de R$ " + valor + " efetuado.");
  }

  @Override
  public double getSaldo() {
    System.out.println("Verificando o saldo...");
    return this.conta.getSaldo();
  }
}

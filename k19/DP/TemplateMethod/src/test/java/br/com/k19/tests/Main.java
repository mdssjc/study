package br.com.k19.tests;

import br.com.k19.abstractclass.Conta;
import br.com.k19.concreteclass.ContaCorrente;
import br.com.k19.concreteclass.ContaPoupanca;

/**
 * Design Pattern
 * Behavioral - Template Method
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Conta contaCorrente = new ContaCorrente();
    final Conta contaPoupanca = new ContaPoupanca();

    contaCorrente.deposita(100);
    contaCorrente.saca(10);

    contaPoupanca.deposita(100);
    contaPoupanca.saca(10);

    System.out.println("Saldo da Conta Corrente: " + contaCorrente.getSaldo());
    System.out.println("Saldo da Conta Poupança: " + contaPoupanca.getSaldo());
  }
}

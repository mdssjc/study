package br.com.k19.concreteclass;

import br.com.k19.abstractclass.Conta;

/**
 * Concrete Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class ContaCorrente extends Conta {

  @Override
  public double calculaTaxa() {
    return 3;
  }
}

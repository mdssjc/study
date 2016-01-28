package br.com.k19.subject;

/**
 * Subject Interface
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public interface Conta {

  void deposita(double valor);

  void saca(double valor);

  double getSaldo();
}

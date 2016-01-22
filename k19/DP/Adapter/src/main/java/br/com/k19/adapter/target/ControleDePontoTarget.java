package br.com.k19.adapter.target;

import br.com.k19.model.Funcionario;

/**
 * Target Adapter Interface
 *
 * @author mdssjc
 *
 */
public interface ControleDePontoTarget {

  void registraEntrada(Funcionario f);

  void registraSaida(Funcionario f);
}

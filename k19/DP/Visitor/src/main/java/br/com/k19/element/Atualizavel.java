package br.com.k19.element;

import br.com.k19.visitor.AtualizadorDeFuncionario;

/**
 * Element Interface
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public interface Atualizavel {

  void aceita(AtualizadorDeFuncionario atualizador);
}

package br.com.k19.visitor;

import br.com.k19.element.concrete.Gerente;
import br.com.k19.element.concrete.Telefonista;

/**
 * Visitor Interface
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public interface AtualizadorDeFuncionario {

  void atualiza(Gerente gerente);

  void atualiza(Telefonista telefonista);
}

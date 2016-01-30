package br.com.k19.observer;

import br.com.k19.subject.concrete.Acao;

/**
 * Observer Interface
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public interface AcaoObserver {

  void notificaAlteracao(Acao acao);
}

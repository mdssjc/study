package br.com.k19.subject;

import br.com.k19.observer.AcaoObserver;

/**
 * Subject Interface
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public interface Subject {

  void registraInteressado(AcaoObserver interessado);

  void cancelaInteressado(AcaoObserver interessado);

  void setValor(double valor);
}

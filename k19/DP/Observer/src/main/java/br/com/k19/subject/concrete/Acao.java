package br.com.k19.subject.concrete;

import java.util.HashSet;
import java.util.Set;

import br.com.k19.observer.AcaoObserver;
import br.com.k19.subject.Subject;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**
 * Concrete Subject Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@RequiredArgsConstructor
public class Acao implements Subject {

  @Getter
  @NonNull
  private final String            codigo;
  @Getter
  @NonNull
  private double                  valor;

  private final Set<AcaoObserver> interessados = new HashSet<>();

  @Override
  public void registraInteressado(final AcaoObserver interessado) {
    this.interessados.add(interessado);
  }

  @Override
  public void cancelaInteressado(final AcaoObserver interessado) {
    this.interessados.remove(interessado);
  }

  @Override
  public void setValor(final double valor) {
    this.valor = valor;
    for (final AcaoObserver interessado : this.interessados) {
      interessado.notificaAlteracao(this);
    }
  }
}

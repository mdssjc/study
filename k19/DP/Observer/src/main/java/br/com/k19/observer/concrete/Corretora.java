package br.com.k19.observer.concrete;

import br.com.k19.observer.AcaoObserver;
import br.com.k19.subject.concrete.Acao;
import lombok.AllArgsConstructor;

/**
 * Concrete Observer Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@AllArgsConstructor
public class Corretora implements AcaoObserver {

  private final String nome;

  @Override
  public void notificaAlteracao(final Acao acao) {
    System.out.println("Corretora " + this.nome + " sendo notificada:");
    System.out.println("A ação " + acao.getCodigo() + " teve o seu valor alterado para " + acao.getValor());
  }
}

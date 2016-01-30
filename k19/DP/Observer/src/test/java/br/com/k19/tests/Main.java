package br.com.k19.tests;

import br.com.k19.observer.AcaoObserver;
import br.com.k19.observer.concrete.Corretora;
import br.com.k19.subject.Subject;
import br.com.k19.subject.concrete.Acao;

/**
 * Design Pattern
 * Behavioral - Observer (Dependents, Publish-Subscribe)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Subject acao = new Acao("VALE3", 45.27);

    final AcaoObserver corretora1 = new Corretora("Corretora1");
    final AcaoObserver corretora2 = new Corretora("Corretora2");

    acao.registraInteressado(corretora1);
    acao.registraInteressado(corretora2);

    acao.setValor(50);
  }
}

package br.com.k19.component.concrete;

import br.com.k19.component.Emissor;

/**
 * Concrete Component Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class EmissorBasico implements Emissor {

  @Override
  public void envia(final String mensagem) {
    System.out.println("Enviando uma mensagem: ");
    System.out.println(mensagem);
  }
}

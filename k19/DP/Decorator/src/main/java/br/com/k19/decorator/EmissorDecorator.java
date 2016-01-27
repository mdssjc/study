package br.com.k19.decorator;

import br.com.k19.component.Emissor;

/**
 * Decorator Interface
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public abstract class EmissorDecorator implements Emissor {

  private final Emissor emissor;

  public EmissorDecorator(final Emissor emissor) {
    this.emissor = emissor;
  }

  @Override
  public abstract void envia(String mensagem);

  public Emissor getEmissor() {
    return this.emissor;
  }
}

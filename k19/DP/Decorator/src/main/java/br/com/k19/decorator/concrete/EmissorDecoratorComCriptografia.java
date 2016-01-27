package br.com.k19.decorator.concrete;

import br.com.k19.component.Emissor;
import br.com.k19.decorator.EmissorDecorator;

/**
 * Concrete Decorator Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class EmissorDecoratorComCriptografia extends EmissorDecorator {

  public EmissorDecoratorComCriptografia(final Emissor emissor) {
    super(emissor);
  }

  @Override
  public void envia(final String mensagem) {
    System.out.println("Enviando mensagem criptografada: ");
    getEmissor().envia(criptografa(mensagem));
  }

  private String criptografa(final String mensagem) {
    final String mensagemCriptogradafa = new StringBuilder(mensagem).reverse().toString();
    return mensagemCriptogradafa;
  }
}

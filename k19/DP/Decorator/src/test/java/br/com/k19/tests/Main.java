package br.com.k19.tests;

import br.com.k19.component.concrete.EmissorBasico;
import br.com.k19.decorator.concrete.EmissorDecoratorComCompressao;
import br.com.k19.decorator.concrete.EmissorDecoratorComCriptografia;

/**
 * Design Pattern
 * Structural - Decorator (Wrapper)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final String mensagem = "";

    final EmissorDecoratorComCriptografia emissorCript = new EmissorDecoratorComCriptografia(new EmissorBasico());
    emissorCript.envia(mensagem);

    final EmissorDecoratorComCompressao emissorCompr = new EmissorDecoratorComCompressao(new EmissorBasico());
    emissorCompr.envia(mensagem);

    final EmissorDecoratorComCriptografia emissorCriptCompr = new EmissorDecoratorComCriptografia(
        new EmissorDecoratorComCompressao(new EmissorBasico()));
    emissorCriptCompr.envia(mensagem);
  }
}

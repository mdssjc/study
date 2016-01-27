package br.com.k19.decorator.concrete;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;

import br.com.k19.component.Emissor;
import br.com.k19.decorator.EmissorDecorator;

/**
 * Concrete Decorator Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class EmissorDecoratorComCompressao extends EmissorDecorator {

  public EmissorDecoratorComCompressao(final Emissor emissor) {
    super(emissor);
  }

  @Override
  public void envia(final String mensagem) {
    System.out.println("Enviando mensagem comprimida: ");
    String mensagemComprimida;
    try {
      mensagemComprimida = comprime(mensagem);
    } catch (final IOException e) {
      mensagemComprimida = mensagem;
    }
    getEmissor().envia(mensagemComprimida);
  }

  private String comprime(final String mensagem) throws IOException {
    final ByteArrayOutputStream out = new ByteArrayOutputStream();
    final DeflaterOutputStream dout = new DeflaterOutputStream(out, new Deflater());
    dout.write(mensagem.getBytes());
    dout.close();
    return new String(out.toByteArray());
  }
}

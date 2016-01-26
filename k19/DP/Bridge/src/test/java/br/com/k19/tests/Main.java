package br.com.k19.tests;

import br.com.k19.abstraction.refined.Recibo;
import br.com.k19.implementor.GeradorDeArquivo;
import br.com.k19.implementor.concrete.GeradorDeArquivoTXT;

/**
 * Design Pattern
 * Structural - Bridge (Handle/Body)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final GeradorDeArquivo geradorDeArquivoTXT = new GeradorDeArquivoTXT();
    final Recibo recibo = new Recibo("K19 Treinamentos", "Marcelo Martins", 1000, geradorDeArquivoTXT);
    recibo.geraArquivo();
  }
}

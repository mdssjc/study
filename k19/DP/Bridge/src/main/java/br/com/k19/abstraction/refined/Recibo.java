package br.com.k19.abstraction.refined;

import br.com.k19.abstraction.Documento;
import br.com.k19.implementor.GeradorDeArquivo;

/**
 * Refined Abstraction Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Recibo implements Documento {

  private final String           emissor;
  private final String           favorecido;
  private final double           valor;
  private final GeradorDeArquivo geradorDeArquivo;

  public Recibo(final String emissor, final String favorecido, final double valor,
      final GeradorDeArquivo geradorDeArquivo) {
    this.emissor = emissor;
    this.favorecido = favorecido;
    this.valor = valor;
    this.geradorDeArquivo = geradorDeArquivo;
  }

  @Override
  public void geraArquivo() {
    final StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Recibo: ");
    stringBuilder.append("\n");
    stringBuilder.append("Empresa: " + emissor);
    stringBuilder.append("\n");
    stringBuilder.append("Cliente: " + favorecido);
    stringBuilder.append("\n");
    stringBuilder.append("Valor: " + valor);
    stringBuilder.append("\n");
    geradorDeArquivo.gera(stringBuilder.toString());
  }
}

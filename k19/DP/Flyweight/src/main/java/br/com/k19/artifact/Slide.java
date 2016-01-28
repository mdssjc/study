package br.com.k19.artifact;

import br.com.k19.flyweight.TemaFlyweight;
import lombok.AllArgsConstructor;

/**
 * Artifact Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@AllArgsConstructor
public class Slide {

  private final TemaFlyweight tema;
  private final String        titulo;
  private final String        texto;

  public void imprime() {
    this.tema.imprime(this.titulo, this.texto);
  }
}

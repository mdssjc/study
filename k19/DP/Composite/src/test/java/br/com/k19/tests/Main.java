package br.com.k19.tests;

import br.com.k19.component.Trecho;
import br.com.k19.component.composite.Caminho;
import br.com.k19.component.leaf.TrechoAndando;
import br.com.k19.component.leaf.TrechoDeCarro;

/**
 * Design Pattern
 * Structural - Composite
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Trecho trecho1 = new TrechoAndando("Vá até o cruzamento da Av. Rebouças com a Av.Brigadeiro Faria Lima", 500);
    final Trecho trecho2 = new TrechoDeCarro(
        "Vá até o cruzamento da Av. Brigadeiro Faria Lima com a Av.Cidade Jardim", 1500);
    final Trecho trecho3 = new TrechoDeCarro("Vire a direita na Marginal Pinheiros", 500);

    final Caminho caminho1 = new Caminho();
    caminho1.adiciona(trecho1);
    caminho1.adiciona(trecho2);

    System.out.println("Caminho 1 : ");
    caminho1.imprime();

    final Caminho caminho2 = new Caminho();
    caminho2.adiciona(caminho1);
    caminho2.adiciona(trecho3);
    System.out.println("---");

    System.out.println("Caminho 2 : ");
    caminho2.imprime();
  }
}

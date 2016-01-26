package br.com.k19.component.leaf;

import br.com.k19.component.Trecho;

/**
 * Leaf Component Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class TrechoAndando implements Trecho {

	private final String direcao;
	private final double distancia;

	public TrechoAndando(final String direcao, final double distancia) {
		this.direcao = direcao;
		this.distancia = distancia;
	}

	@Override
	public void imprime() {
		System.out.println("Vá andando: ");
		System.out.println(this.direcao);
		System.out.println("A distância percorrida será de: " + this.distancia + " metros.");
	}
}

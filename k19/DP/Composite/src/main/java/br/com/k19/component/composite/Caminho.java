package br.com.k19.component.composite;

import java.util.ArrayList;
import java.util.List;

import br.com.k19.component.Trecho;

/**
 * Composite Component Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Caminho implements Trecho {

	private final List<Trecho> trechos;

	public Caminho() {
		this.trechos = new ArrayList<>();
	}

	public void adiciona(final Trecho trecho) {
		this.trechos.add(trecho);
	}

	public void remove(final Trecho trecho) {
		this.trechos.remove(trecho);
	}

	@Override
	public void imprime() {
		for (final Trecho trecho : this.trechos) {
			trecho.imprime();
		}
	}
}

package br.com.k19.implementor.concrete;

import java.io.FileNotFoundException;
import java.io.PrintStream;

import br.com.k19.implementor.GeradorDeArquivo;

/**
 * Concrete Implementor Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class GeradorDeArquivoTXT implements GeradorDeArquivo {

	@Override
	public void gera(final String conteudo) {
		try {
			final PrintStream saida = new PrintStream("arquivo.txt");
			saida.println(conteudo);
			saida.close();
		} catch (final FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

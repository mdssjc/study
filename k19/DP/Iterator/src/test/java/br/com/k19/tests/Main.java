package br.com.k19.tests;

import java.util.Iterator;

import br.com.k19.iterator.concrete.ListaDeNomes;

/**
 * Design Pattern
 * Behavioral - Iterator (Cursor)
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class Main {

  public static void main(final String[] args) {
    final String[] nomes = new String[4];
    nomes[0] = "Rafael Cosentino";
    nomes[1] = "Marcelo Martins";
    nomes[2] = "Jonas Hirata";
    nomes[3] = "Solange Domingues";

    final ListaDeNomes listaDeNomes = new ListaDeNomes(nomes);
    final Iterator<String> iterator = listaDeNomes.iterator();
    iterator.next();
    iterator.remove();

    while (iterator.hasNext()) {
      final String nome = iterator.next();
      System.out.println(nome);
    }

    System.out.println("---");
    System.out.println("Testando o foreach");
    for (final String nome : listaDeNomes) {
      System.out.println(nome);
    }
  }
}

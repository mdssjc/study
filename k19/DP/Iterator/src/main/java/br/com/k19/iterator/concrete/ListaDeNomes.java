package br.com.k19.iterator.concrete;

import java.util.Iterator;

/**
 * Concrete Iterator Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public class ListaDeNomes implements Iterable<String> {

  private final String[] nomes;
  private int            lenght;

  public ListaDeNomes(final String[] nomes) {
    this.nomes = nomes;
    this.lenght = nomes.length;
  }

  @Override
  public Iterator<String> iterator() {
    return new Iterator<String>() {

      private int i = 0;

      @Override
      public boolean hasNext() {
        return (this.i) < ListaDeNomes.this.lenght;
      }

      @Override
      public String next() {
        return ListaDeNomes.this.nomes[this.i++];
      }

      @Override
      public void remove() {
        ListaDeNomes.this.nomes[this.i] = null;

        for (int j = this.i; j + 1 < ListaDeNomes.this.lenght; j++) {
          ListaDeNomes.this.nomes[j] = ListaDeNomes.this.nomes[j + 1];
        }
        ListaDeNomes.this.lenght--;
      }
    };
  }
}

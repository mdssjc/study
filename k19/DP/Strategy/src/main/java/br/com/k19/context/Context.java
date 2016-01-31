package br.com.k19.context;

import java.util.List;

import br.com.k19.strategy.Sorter;
import br.com.k19.strategy.concrete.NullSorter;
import lombok.Setter;

/**
 * Context Class
 *
 * @author mdssjc <Marcelo dos Santos>
 * @param <T>
 *
 */
public class Context {

  @Setter
  private Sorter sorter;

  public Context() {
    this.sorter = new NullSorter();
  }

  public <T extends Comparable<? super T>> List<T> run(final List<T> list) {
    return this.sorter.sort(list);
  }

  @Override
  public String toString() {
    return this.sorter.toString();
  }
}

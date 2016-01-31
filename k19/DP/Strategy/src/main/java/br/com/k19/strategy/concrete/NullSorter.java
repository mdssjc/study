package br.com.k19.strategy.concrete;

import java.util.ArrayList;
import java.util.List;

import br.com.k19.strategy.Sorter;
import lombok.ToString;

/**
 * Concrete Strategy Class
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
@ToString
public class NullSorter implements Sorter {

  @Override
  public <T extends Comparable<? super T>> List<T> sort(final List<T> list) {
    return new ArrayList<T>(list);
  }
}

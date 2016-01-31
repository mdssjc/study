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
public class InsertionSorter implements Sorter {

  @Override
  public <T extends Comparable<? super T>> List<T> sort(List<T> list) {
    list = new ArrayList<T>(list);
    for (int i = 1; i < list.size(); i++) {
      final T a = list.get(i);
      int j;
      for (j = i - 1; j >= 0 && list.get(j).compareTo(a) > 0; j--) {
        list.remove(j + 1);
        list.add(j + 1, list.get(j));
        list.remove(j);
        list.add(j, a);
      }
    }
    return list;
  }
}

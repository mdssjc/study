package br.com.k19.strategy;

import java.util.List;

/**
 * Strategy Interface
 *
 * @author mdssjc <Marcelo dos Santos>
 *
 */
public interface Sorter {

  <T extends Comparable<? super T>> List<T> sort(List<T> list);
}

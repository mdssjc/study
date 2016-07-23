package com.github.mdssjc.hfooad.ricksguitars;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Inventory Class.
 *
 * @author Marcelo dos Santos
 * @param <T>
 *          Type
 * @param <S>
 *          Specification
 */
public class Inventory<T, S> {

  private final List<T> list;

  public Inventory() {
    this.list = new ArrayList<>();
  }

  public void add(final T item) {
    this.list.add(item);
  }

  public T get(final String id) {
    return this.list.stream()
                    .filter(item -> item.equals(id))
                    .findFirst()
                    .orElse(null);
  }

  public Iterator<T> search(final S search) {
    return this.list.stream()
                    .filter(item -> item.equals(search))
                    .iterator();
  }
}

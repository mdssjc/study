package com.github.mdssjc.hfl.ooad.base;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Inventory Class
 *
 * @author mdssjc
 *
 * @param <T>
 *          Type
 * @param <S>
 *          Specification
 */
public class Inventory<T, S> {

  private final List<T> list;

  public Inventory() {
    this.list = new LinkedList<>();
  }

  public void add(final T type) {
    this.list.add(type);
  }

  public T get(final String id) {
    for (final T element : this.list) {
      if (element.equals(id)) {
        return element;
      }
    }
    return null;
  }

  public List<T> search(final S search) {
    return this.list.stream()
                    .filter(item -> item.equals(search))
                    .collect(Collectors.toList());
  }
}

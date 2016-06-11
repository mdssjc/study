package com.github.mdssjc.hfl.ooad.base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Inventory<T> {

  private final List<T> list;

  public Inventory() {
    this.list = new LinkedList<T>();
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

  public List<T> search(final Object search) {
    final List<T> matching = new ArrayList<>();
    for (final T element : this.list) {
      if (element.equals(search)) {
        matching.add(element);
      }
    }
    return matching;
  }
}

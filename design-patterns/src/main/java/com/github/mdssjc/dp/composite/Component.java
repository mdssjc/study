package com.github.mdssjc.dp.composite;

/**
 * Interface Component.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Component {

  void operation();

  void add(Component component);

  void remove(Component component);

  Component getChild(int id);
}

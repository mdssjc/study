package com.github.mdssjc.dp.adapter.base;

import com.github.mdssjc.dp.adapter.adaptee.Adaptee;
import com.github.mdssjc.dp.adapter.adapter.Adapter;
import com.github.mdssjc.dp.adapter.adapter.Target;

/**
 * Test drive do padrão de projeto Adapter.
 * <p>
 * Design Pattern
 * Structural - Adapter (Wrapper)
 * <p>
 * Adaptador do objeto
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Target target = new Adapter(new Adaptee());
    target.request();
  }
}

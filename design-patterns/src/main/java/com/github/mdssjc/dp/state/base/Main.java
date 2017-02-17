package com.github.mdssjc.dp.state.base;

import com.github.mdssjc.dp.state.context.Context;

/**
 * Test drive do padrão de projeto State.
 * <p>
 * Design Pattern
 * Behavioral - State (Objects for States)
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Context context = new Context();

    context.requestA();
    context.requestB();
    context.requestA();
    context.requestB();
    context.requestC();
  }
}

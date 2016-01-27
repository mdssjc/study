/*
 * Design Pattern
 * Behavioral - State (Objects for States)
 *
 */
package base;

import context.Context;

public class Main {

  public static void main(final String[] args) {
    final Context context = new Context();

    context.stateA();
    context.stateB();
    context.stateA();
    context.stateB();
    context.stateC();
  }
}

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

    context.requestA();
    context.requestB();
    context.requestA();
    context.requestB();
    context.requestC();
  }
}

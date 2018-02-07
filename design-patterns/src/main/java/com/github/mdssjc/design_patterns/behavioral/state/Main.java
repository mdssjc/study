package com.github.mdssjc.design_patterns.behavioral.state;

/**
 * Padrão de projeto: State.
 * <p>
 * Design Pattern
 * Object Behavioral / Operations - State (Objects for States)
 * <p>
 * O padrão State permite a um objeto alterar seu comportamento quando o seu
 * estado interno muda. O objeto parecerá ter mudado sua classe.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Context context = new Context();
    context.request();
    context.request();
    context.request();
  }
}

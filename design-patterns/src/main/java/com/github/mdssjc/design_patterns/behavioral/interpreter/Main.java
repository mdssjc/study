package com.github.mdssjc.design_patterns.behavioral.interpreter;

/**
 * Padrão de projeto: Interpreter.
 * <p>
 * Design Pattern
 * Class Behavioral / Operations - Interpreter
 * <p>
 * O padrão Interpreter, dada uma linguagem, define uma representação para a sua
 * gramática juntamente com um interpretador que usa a representação para
 * interpretar sentenças dessa linguagem.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Context context = new Context();

    final TerminalExpression a = new TerminalExpression("a");
    final TerminalExpression b = new TerminalExpression("b");
    final TerminalExpression c = new TerminalExpression("c");

    context.assign(a, 2);
    context.assign(b, 3);
    context.assign(c, 5);

    final AbstractExpression interpreter = new NonterminalExpression(
        new NonterminalExpression(a, b), c);

    final int result = interpreter.interpret(context);
    System.out.println(result);
  }
}

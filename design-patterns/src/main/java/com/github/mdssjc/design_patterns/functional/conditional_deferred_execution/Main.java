package com.github.mdssjc.design_patterns.functional.conditional_deferred_execution;

/**
 * Padrão de projeto: Conditional Deferred Execution.
 *
 * @author Marcelo dos Santos
 */
public class Main {

  public static void main(final String[] args) {
    final Service service = new Service();

    final boolean no = false;
    final boolean yes = true;

    service.print(no, () -> "No message!");
    service.print(yes, () -> "Yes message!");
  }
}

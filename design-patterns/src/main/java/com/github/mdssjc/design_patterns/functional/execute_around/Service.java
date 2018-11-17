package com.github.mdssjc.design_patterns.functional.execute_around;

import java.io.PrintWriter;

/**
 * Service.
 *
 * @author Marcelo dos Santos
 */
public class Service {

  public void execute(final PrintAction action) {
    try (final PrintWriter printWriter = new PrintWriter(System.out)) {
      action.print(printWriter);
    }
  }
}

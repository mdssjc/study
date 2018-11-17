package com.github.mdssjc.design_patterns.functional.execute_around;

import java.io.PrintWriter;

/**
 * Print Action.
 *
 * @author Marcelo dos Santos
 */
@FunctionalInterface
public interface PrintAction {

  void print(PrintWriter writer);
}

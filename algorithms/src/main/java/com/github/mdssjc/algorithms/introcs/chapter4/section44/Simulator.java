package com.github.mdssjc.algorithms.introcs.chapter4.section44;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Lookup.class, "Program 4.4.1 Dictionary lookup");
    Executor.execute(Index.class, "Program 4.4.2 Indexing");
    Executor.execute(HashST.class, "Program 4.4.3 Hash table");
    Executor.execute(BST.class, "Program 4.4.4 Binary search tree");
    Executor.execute(DeDup.class, "Program 4.4.5 Dedup filter");
  }
}

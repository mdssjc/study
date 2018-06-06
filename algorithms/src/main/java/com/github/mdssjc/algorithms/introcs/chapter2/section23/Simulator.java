package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(Euclid.class, "Program 2.3.1 Euclid’s algorithm");
    Executor.execute(TowersOfHanoi.class, "Program 2.3.2 Towers of Hanoi");
    Executor.execute(Beckett.class, "Program 2.3.3 Gray code");
    Executor.execute(Htree.class, "Program 2.3.4 Recursive graphics");
    Executor.execute(Brownian.class, "Program 2.3.5 Brownian bridge");
    Executor.execute(LongestCommonSubsequence.class, "Program 2.3.6 Longest common subsequence");
  }
}

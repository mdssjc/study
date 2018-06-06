package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.3.6 Longest common subsequence.
 * <p>
 * Compilation:  javac LongestCommonSubsequence.java
 * Execution:    java LongestCommonSubsequence s t
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"GGCACCACG", "ACGGCGGATACG"})
public class LongestCommonSubsequence {

  public static String lcs(final String x, final String y) {
    final var m = x.length();
    final var n = y.length();
    final var opt = new int[m + 1][n + 1];
    for (var i = m - 1; i >= 0; i--) {
      for (var j = n - 1; j >= 0; j--) {
        if (x.charAt(i) == y.charAt(j)) {
          opt[i][j] = opt[i + 1][j + 1] + 1;
        } else {
          opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
        }
      }
    }

    var lcs = "";
    int i = 0, j = 0;
    while (i < m && j < n) {
      if (x.charAt(i) == y.charAt(j)) {
        lcs += x.charAt(i);
        i++;
        j++;
      } else if (opt[i + 1][j] >= opt[i][j + 1]) {
        i++;
      } else {
        j++;
      }
    }
    return lcs;
  }

  public static void main(final String[] args) {
    Executor.execute(LongestCommonSubsequence.class, args);

    final var lcs = lcs(args[0], args[1]);
    StdOut.println(lcs);
  }
}

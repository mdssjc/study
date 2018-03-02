package com.github.mdssjc.algorithms.introcs.chapter2.section23;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 2.3.6 Longest common subsequence.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"GGCACCACG", "ACGGCGGATACG"})
public class LongestCommonSubsequence {

  public static String lcs(final String s, final String t) {
    final int m = s.length();
    final int n = t.length();
    final int[][] opt = new int[m + 1][n + 1];
    for (int i = m - 1; i >= 0; i--) {
      for (int j = n - 1; j >= 0; j--) {
        if (s.charAt(i) == t.charAt(j)) {
          opt[i][j] = opt[i + 1][j + 1] + 1;
        } else {
          opt[i][j] = Math.max(opt[i + 1][j], opt[i][j + 1]);
        }
      }
    }

    String lcs = "";
    int i = 0, j = 0;
    while (i < m && j < n) {
      if (s.charAt(i) == t.charAt(j)) {
        lcs += s.charAt(i);
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

    StdOut.println(lcs(args[0], args[1]));
  }
}

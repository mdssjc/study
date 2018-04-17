package com.github.mdssjc.algorithms.introcs.chapter4.section41;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 4.1.1 3-sum problem.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "8ints.txt", inputFile = true)
@TestDrive(input = "1Kints.txt", inputFile = true)
public class ThreeSum {

  public static void printTriples(final int[] a) {
    final int n = a.length;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (a[i] + a[j] + a[k] == 0) {
            StdOut.println(a[i] + " " + a[j] + " " + a[k]);
          }
        }
      }
    }
  }

  public static int countTriples(final int[] a) {
    final int n = a.length;
    int count = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        for (int k = j + 1; k < n; k++) {
          if (a[i] + a[j] + a[k] == 0) {
            count++;
          }
        }
      }
    }
    return count;
  }

  public static void main(final String[] args) {
    Executor.execute(ThreeSum.class, args);

    final int[] a = StdIn.readAllInts();
    final int count = countTriples(a);
    StdOut.println(count);
    if (count < 10) {
      printTriples(a);
    }
  }
}

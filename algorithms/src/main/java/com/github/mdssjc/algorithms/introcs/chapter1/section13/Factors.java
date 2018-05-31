package com.github.mdssjc.algorithms.introcs.chapter1.section13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.3.9 Factoring integers.
 * <p>
 * Compilation:  javac Factors.java
 * Execution:    java Factors n
 * <p>
 * Computes the prime factorization of n using brute force.
 * <p>
 * % java Factors 81
 * The prime factorization of 81 is: 3 3 3 3
 * <p>
 * % java Factors 168
 * The prime factorization of 168 is: 2 2 2 3 7
 * <p>
 * % java Factors 4444444444
 * The prime factorization of 4444444444 is: 2 2 11 41 271 9091
 * <p>
 * % java Factors 4444444444444463
 * The prime factorization of 4444444444444463 is: 4444444444444463
 * <p>
 * % java Factors 10000001400000049
 * The prime factorization of 10000001400000049 is: 100000007 100000007
 * <p>
 * % java Factors 1000000014000000049
 * The prime factorization of 1000000014000000049 is: 1000000007 1000000007
 * <p>
 * % java Factors 9201111169755555649
 * The prime factorization of 9201111169755555649 is: 3033333343 3033333343
 * <p>
 * Can use these for timing tests - biggest 3, 6, 9, 12, 15, and 18 digit primes
 * % java Factors 997
 * % java Factors 999983
 * % java Factors 999999937
 * % java Factors 999999999989
 * % java Factors 999999999999989
 * % java Factors 999999999999999989
 * <p>
 * Remarks
 * -------
 * - Tests factor*factor <= n instead of factor <= n for efficiency.
 * <p>
 * - The last two examples still take a few minutes.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("81")
@TestDrive("168")
@TestDrive("4444444444")
@TestDrive("4444444444444463")
@TestDrive("10000001400000049")
@TestDrive("1000000014000000049")
@TestDrive("9201111169755555649")
public class Factors {

  public static void main(final String[] args) {
    Executor.execute(Factors.class, args);

    var n = Long.parseLong(args[0]);

    System.out.print("The prime factorization of " + n + " is: ");

    for (long factor = 2; factor*factor <= n; factor++) {
      while (n % factor == 0) {
        System.out.print(factor + " ");
        n /= factor;
      }
    }

    if (n > 1) {
      System.out.println(n);
    } else {
      System.out.println();
    }
  }
}

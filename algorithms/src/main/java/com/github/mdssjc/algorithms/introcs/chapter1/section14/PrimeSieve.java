package com.github.mdssjc.algorithms.introcs.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.4.3 Sieve of Eratosthenes.
 * <p>
 * Compilation:  javac PrimeSieve.java
 * Execution:    java -Xmx1100m PrimeSieve n
 * <p>
 * Computes the number of primes less than or equal to n using
 * the Sieve of Eratosthenes.
 * <p>
 * % java PrimeSieve 25
 * The number of primes <= 25 is 9
 * <p>
 * % java PrimeSieve 100
 * The number of primes <= 100 is 25
 * <p>
 * % java -Xmx100m PrimeSieve 100000000
 * The number of primes <= 100000000 is 5761455
 * <p>
 * % java PrimeSieve -Xmx1100m 1000000000
 * The number of primes <= 1000000000 is 50847534
 * <p>
 * <p>
 * The 110MB and 1100MB is the amount of memory you want to allocate
 * to the program. If your computer has less, make this number smaller,
 * but it may prevent you from solving the problem for very large
 * values of n.
 * <p>
 * <p>
 *                  n     Primes <= n
 *  ---------------------------------
 *                 10               4
 *                100              25
 *              1,000             168
 *             10,000           1,229
 *            100,000           9,592
 *          1,000,000          78,498
 *         10,000,000         664,579
 *        100,000,000       5,761,455
 *      1,000,000,000      50,847,534
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("25")
@TestDrive("100")
@TestDrive("100000000")  // configure o -Xmx#### na execução
@TestDrive("1000000000") // configure o -Xmx#### na execução
public class PrimeSieve {

  public static void main(final String[] args) {
    Executor.execute(PrimeSieve.class, args);

    final var n = Integer.parseInt(args[0]);

    final var isPrime = new boolean[n + 1];
    for (var i = 2; i <= n; i++) {
      isPrime[i] = true;
    }

    for (var factor = 2; factor * factor <= n; factor++) {
      if (isPrime[factor]) {
        for (var j = factor; factor * j <= n; j++) {
          isPrime[factor * j] = false;
        }
      }
    }

    var primes = 0;
    for (var i = 2; i <= n; i++) {
      if (isPrime[i]) {
        primes++;
      }
    }
    System.out.println("The number of primes <= " + n + " is " + primes);
  }
}

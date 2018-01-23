package com.github.mdssjc.algorithms.introcs.chapter1.section14;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Program 1.4.3 Sieve of Eratosthenes.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("25")
@TestDrive("100")
@TestDrive("1000000000") // configure o -Xmx#### na execução
public class PrimeSieve {

  public static void main(final String[] args) {
    Executor.execute(PrimeSieve.class, args);

    final int n = Integer.parseInt(args[0]);

    final boolean[] isPrime = new boolean[n + 1];
    for (int i = 2; i <= n; i++) {
      isPrime[i] = true;
    }
    for (int i = 2; i <= n / i; i++) {
      if (isPrime[i]) {
        for (int j = i; j <= n / i; j++) {
          isPrime[i * j] = false;
        }
      }
    }

    int primes = 0;
    for (int i = 2; i <= n; i++) {
      if (isPrime[i]) {
        primes++;
      }
    }
    System.out.println(primes);
  }
}

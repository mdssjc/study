package com.github.mdssjc.design_patterns.recursion.trampoline;

import java.math.BigInteger;

/**
 * Padrão Trampoline.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static Trampoline<BigInteger> factorial(final int n, final BigInteger sum) {
    if (n <= 1) {
      return new Trampoline<BigInteger>() {
        @Override
        public BigInteger get() {
          return sum;
        }
      };
    } else {
      return new Trampoline<BigInteger>() {
        @Override
        public Trampoline<BigInteger> run() {
          return factorial(n - 1, sum.multiply(BigInteger.valueOf(n)));
        }
      };
    }
  }

  public static void main(final String[] args) {
    System.out.println(factorial(100000, BigInteger.ONE).execute());
  }
}

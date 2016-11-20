package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 17.
 * <p>
 * Robust implementation of rational numbers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx17 {

  public static void main(final String[] args) {
    Executor.execute(CEx17.class, args);

    RationalCEx17 x;
    RationalCEx17 y;
    RationalCEx17 z;

    // 1/2 + 1/3 = 5/6
    x = new RationalCEx17(1, 2);
    y = new RationalCEx17(1, 3);
    z = x.plus(y);
    StdOut.println(z);

    // 8/9 + 1/9 = 1
    x = new RationalCEx17(8, 9);
    y = new RationalCEx17(1, 9);
    z = x.plus(y);
    StdOut.println(z);

    //  4/17 * 7/3 = 28/51
    x = new RationalCEx17(4, 17);
    y = new RationalCEx17(7, 3);
    z = x.times(y);
    StdOut.println(z);

    // 203/16957 * 9299/5887 = 17/899
    x = new RationalCEx17(203, 16957);
    y = new RationalCEx17(9299, 5887);
    z = x.times(y);
    StdOut.println(z);

    // 3/5 / 1/2 = 6/5
    x = new RationalCEx17(3, 5);
    y = new RationalCEx17(1, 2);
    z = x.dividedBy(y);
    StdOut.println(z);

    // 1/6 - -4/-8 = -1/3
    x = new RationalCEx17(1, 6);
    y = new RationalCEx17(-4, -8);
    z = x.minus(y);
    StdOut.println(z);

    // 0/6 = 0
    x = new RationalCEx17(0, 6);
    StdOut.println(x);
  }
}

class RationalCEx17 implements Comparable<RationalCEx17> {

  private static final RationalCEx17 zero = new RationalCEx17(0, 1);

  private long num;   // the numerator
  private long den;   // the denominator

  // create and initialize a new Rational object
  public RationalCEx17(final long numerator, final long denominator) {

    // deal with x/0
    if (denominator == 0) {
      throw new ArithmeticException("denominator is zero");
    }

    // reduce fraction
    final long g = gcd(numerator, denominator);
    num = numerator / g;
    den = denominator / g;

    // only needed for negative numbers
    if (den < 0) {
      den = -den;
      num = -num;
    }
  }

  // return the numerator and denominator of this rational number
  public long numerator() {
    return num;
  }

  public long denominator() {
    return den;
  }

  // return double precision representation of this rational number
  public double toDouble() {
    return (double) num / den;
  }

  // return string representation of this rational number
  public String toString() {
    if (den == 1) return num + "";
    else return num + "/" + den;
  }

  // return { -1, 0, +1 } if this < that, this = that, or this > that
  public int compareTo(final RationalCEx17 that) {
    final long lhs = this.num * that.den;
    final long rhs = this.den * that.num;
    if (lhs < rhs) return -1;
    if (lhs > rhs) return +1;
    return 0;
  }

  // is this RationalCEx17 object equal to other?
  public boolean equals(final Object other) {
    if (other == null) return false;
    if (other.getClass() != this.getClass()) return false;
    final RationalCEx17 that = (RationalCEx17) other;
    return this.compareTo(that) == 0;
  }

  // hashCode consistent with equals() and compareTo()
  public int hashCode() {
    return this.toString()
               .hashCode();
  }

  // return this * that, staving off overflow as much as possible by cross-cancellation
  public RationalCEx17 times(final RationalCEx17 that) {

    // reduce p1/q2 and p2/q1, then multiply, where a = p1/q1 and b = p2/q2
    final RationalCEx17 c = new RationalCEx17(this.num, that.den);
    final RationalCEx17 d = new RationalCEx17(that.num, this.den);
    return new RationalCEx17(c.num * d.num, c.den * d.den);
  }

  // return this + that, staving off overflow
  public RationalCEx17 plus(final RationalCEx17 that) {

    // special cases
    if (this.compareTo(zero) == 0) return that;
    if (that.compareTo(zero) == 0) return this;

    // Find gcd of numerators and denominators
    final long f = gcd(this.num, that.num);
    final long g = gcd(this.den, that.den);

    // add cross-product terms for numerator
    final RationalCEx17 s = new RationalCEx17((this.num / f) * (that.den / g)
                                                  + (that.num / f) * (this.den / g),
                                              this.den * (that.den / g));

    // multiply back in
    s.num *= f;
    return s;
  }

  // return -this
  public RationalCEx17 negate() {
    return new RationalCEx17(-num, den);
  }

  // return this - that
  public RationalCEx17 minus(final RationalCEx17 that) {
    return this.plus(that.negate());
  }

  public RationalCEx17 reciprocal() {
    return new RationalCEx17(den, num);
  }

  // return this / that
  public RationalCEx17 dividedBy(final RationalCEx17 that) {
    return this.times(that.reciprocal());
  }

  // create and return a new rational (r.num + s.num) / (r.den + s.den)
  public static RationalCEx17 mediant(final RationalCEx17 r, final RationalCEx17 s) {
    return new RationalCEx17(r.num + s.num, r.den + s.den);
  }

  // return gcd(|m|, |n|)
  private static long gcd(long m, long n) {
    if (m < 0) m = -m;
    if (n < 0) n = -n;
    if (0 == n) return m;
    else return gcd(n, m % n);
  }

  // return lcm(|m|, |n|)
  private static long lcm(long m, long n) {
    if (m < 0) m = -m;
    if (n < 0) n = -n;
    return m * (n / gcd(m, n));    // parentheses important to avoid overflow
  }
}

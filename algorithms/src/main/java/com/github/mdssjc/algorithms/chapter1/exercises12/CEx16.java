package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 16.
 * <p>
 * Rational numbers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx16 {

  public static void main(final String[] args) {
    Executor.execute(CEx16.class, args);

    Rational x;
    Rational y;
    Rational z;

    // 1/2 + 1/3 = 5/6
    x = new Rational(1, 2);
    y = new Rational(1, 3);
    z = x.plus(y);
    StdOut.println(z);

    // 8/9 + 1/9 = 1
    x = new Rational(8, 9);
    y = new Rational(1, 9);
    z = x.plus(y);
    StdOut.println(z);

    //  4/17 * 7/3 = 28/51
    x = new Rational(4, 17);
    y = new Rational(7, 3);
    z = x.times(y);
    StdOut.println(z);

    // 203/16957 * 9299/5887 = 17/899
    x = new Rational(203, 16957);
    y = new Rational(9299, 5887);
    z = x.times(y);
    StdOut.println(z);

    // 3/5 / 1/2 = 6/5
    x = new Rational(3, 5);
    y = new Rational(1, 2);
    z = x.dividedBy(y);
    StdOut.println(z);

    // 1/6 - -4/-8 = -1/3
    x = new Rational(1, 6);
    y = new Rational(-4, -8);
    z = x.minus(y);
    StdOut.println(z);

    // 0/6 = 0
    x = new Rational(0, 6);
    StdOut.println(x);
  }
}

class Rational {

  private long numerator;
  private long denominator;

  public Rational(final long numerator, final long denominator) {
    if (denominator == 0) {
      throw new ArithmeticException("Denominator is zero");
    }
    final long gcd = gcd(numerator, denominator);

    this.numerator = numerator / gcd;
    this.denominator = denominator / gcd;

    if (this.denominator < 0) {
      this.denominator = -this.denominator;
      this.numerator = -this.numerator;
    }
  }

  public long numerator() {
    return this.numerator;
  }

  public long denominator() {
    return this.denominator;
  }

  public Rational plus(final Rational b) {
    final long numerator = (this.numerator * b.denominator) + (this.denominator * b.numerator);
    final long denominator = this.denominator * b.denominator;
    return new Rational(numerator, denominator);
  }

  public Rational minus(final Rational b) {
    return plus(new Rational(-b.numerator, b.denominator));
  }

  public Rational times(final Rational b) {
    return new Rational(this.numerator * b.numerator, this.denominator * b.denominator);
  }

  public Rational dividedBy(final Rational b) {
    return times(new Rational(b.denominator, b.numerator));
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Rational rational = (Rational) o;
    if (this.numerator != rational.numerator) {
      return false;
    }
    return this.denominator == rational.denominator;
  }

  @Override
  public int hashCode() {
    int result = (int) (this.numerator ^ (this.numerator >>> 32));
    result = 31 * result + (int) (this.denominator ^ (this.denominator >>> 32));
    return result;
  }

  @Override
  public String toString() {
    if (this.denominator == 1) {
      return this.numerator + "";
    } else {
      return this.numerator + "/" + this.denominator;
    }
  }

  private long gcd(final long p, final long q) {
    if (q == 0) {
      return p;
    }
    final long r = p % q;
    return gcd(q, r);
  }
}

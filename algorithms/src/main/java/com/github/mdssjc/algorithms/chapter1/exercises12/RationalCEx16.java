package com.github.mdssjc.algorithms.chapter1.exercises12;

/**
 * RationalCEx16 Class.
 *
 * @author Marcelo dos Santos
 *
 */
class RationalCEx16 {

  private long numerator;
  private long denominator;

  public RationalCEx16(final long numerator, final long denominator) {
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

  public RationalCEx16 plus(final RationalCEx16 b) {
    final long numerator = (this.numerator * b.denominator) + (this.denominator * b.numerator);
    final long denominator = this.denominator * b.denominator;
    return new RationalCEx16(numerator, denominator);
  }

  public RationalCEx16 minus(final RationalCEx16 b) {
    return plus(new RationalCEx16(-b.numerator, b.denominator));
  }

  public RationalCEx16 times(final RationalCEx16 b) {
    return new RationalCEx16(this.numerator * b.numerator, this.denominator * b.denominator);
  }

  public RationalCEx16 dividedBy(final RationalCEx16 b) {
    return times(new RationalCEx16(b.denominator, b.numerator));
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final RationalCEx16 rational = (RationalCEx16) o;
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

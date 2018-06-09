package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

import java.util.Objects;

/**
 * Program 3.2.6 Complex number.
 * <p>
 * Compilation:  javac Complex.java
 * Execution:    java Complex
 * <p>
 * Data type for complex numbers.
 * <p>
 * The data type is "immutable" so once you create and initialize
 * a Complex object, you cannot change it. The "final" keyword
 * when declaring re and im enforces this rule, making it a
 * compile-time error to change the .re or .im instance variables after
 * they've been initialized.
 * <p>
 * % java Complex
 * a            = 5.0 + 6.0i
 * b            = -3.0 + 4.0i
 * Re(a)        = 5.0
 * Im(a)        = 6.0
 * b + a        = 2.0 + 10.0i
 * a - b        = 8.0 + 2.0i
 * a * b        = -39.0 + 2.0i
 * b * a        = -39.0 + 2.0i
 * a / b        = 0.36 - 1.52i
 * (a / b) * b  = 5.0 + 6.0i
 * conj(a)      = 5.0 - 6.0i
 * |a|          = 7.810249675906654
 * tan(a)       = -6.685231390246571E-6 + 1.0000103108981198i
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Complex {

  private final double re;
  private final double im;

  public Complex(final double real, final double imag) {
    this.re = real;
    this.im = imag;
  }

  @Override
  public String toString() {
    if (this.im == 0) {
      return this.re + "";
    }
    if (this.re == 0) {
      return this.im + "i";
    }
    if (this.im < 0) {
      return this.re + " - " + (-this.im) + "i";
    }
    return this.re + " + " + this.im + "i";
  }

  public double abs() {
    return Math.hypot(this.re, this.im);
  }

  public double phase() {
    return Math.atan2(this.im, this.re);
  }

  public Complex plus(final Complex b) {
    final var a = this;
    final var real = a.re + b.re;
    final var imag = a.im + b.im;
    return new Complex(real, imag);
  }

  public Complex minus(final Complex b) {
    final var a = this;
    final var real = a.re - b.re;
    final var imag = a.im - b.im;
    return new Complex(real, imag);
  }

  public Complex times(final Complex b) {
    final var a = this;
    final var real = a.re * b.re - a.im * b.im;
    final var imag = a.re * b.im + a.im * b.re;
    return new Complex(real, imag);
  }

  public Complex scale(final double alpha) {
    return new Complex(alpha * this.re, alpha * this.im);
  }

  public Complex conjugate() {
    return new Complex(this.re, -this.im);
  }

  public Complex reciprocal() {
    final var scale = this.re * this.re + this.im * this.im;
    return new Complex(this.re / scale, -this.im / scale);
  }

  public double re() {
    return this.re;
  }

  public double im() {
    return this.im;
  }

  public Complex divides(final Complex b) {
    final var a = this;
    return a.times(b.reciprocal());
  }

  public Complex exp() {
    return new Complex(Math.exp(this.re) * Math.cos(this.im),
                       Math.exp(this.re) * Math.sin(this.im));
  }

  public Complex sin() {
    return new Complex(Math.sin(this.re) * Math.cosh(this.im),
                       Math.cos(this.re) * Math.sinh(this.im));
  }

  public Complex cos() {
    return new Complex(Math.cos(this.re) * Math.cosh(this.im),
                       -Math.sin(this.re) * Math.sinh(this.im));
  }

  public Complex tan() {
    return sin().divides(cos());
  }

  public static Complex plus(final Complex a, final Complex b) {
    final var real = a.re + b.re;
    final var imag = a.im + b.im;
    final var sum = new Complex(real, imag);
    return sum;
  }

  @Override
  public boolean equals(final Object x) {
    if (x == null) {
      return false;
    }
    if (this.getClass() != x.getClass()) {
      return false;
    }
    final var that = (Complex) x;
    return (this.re == that.re) && (this.im == that.im);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.re, this.im);
  }

  public static void main(final String[] args) {
    Executor.execute(Complex.class, args);

    final var a = new Complex(5.0, 6.0);
    final var b = new Complex(-3.0, 4.0);

    StdOut.println("a            = " + a);
    StdOut.println("b            = " + b);
    StdOut.println("Re(a)        = " + a.re());
    StdOut.println("Im(a)        = " + a.im());
    StdOut.println("b + a        = " + b.plus(a));
    StdOut.println("a - b        = " + a.minus(b));
    StdOut.println("a * b        = " + a.times(b));
    StdOut.println("b * a        = " + b.times(a));
    StdOut.println("a / b        = " + a.divides(b));
    StdOut.println("(a / b) * b  = " + a.divides(b)
                                        .times(b));
    StdOut.println("conj(a)      = " + a.conjugate());
    StdOut.println("|a|          = " + a.abs());
    StdOut.println("tan(a)       = " + a.tan());
  }
}

package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.2.6 Complex number.
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

  public Complex plus(final Complex b) {
    final double real = this.re + b.re;
    final double imag = this.im + b.im;
    return new Complex(real, imag);
  }

  public Complex times(final Complex b) {
    final double real = this.re * b.re - this.im * b.im;
    final double imag = this.re * b.im + this.im * b.re;
    return new Complex(real, imag);
  }

  public double abs() {
    return Math.sqrt(this.re * this.re + this.im * this.im);
  }

  public double re() {
    return this.re;
  }

  public double im() {
    return this.im;
  }

  @Override
  public String toString() {
    return this.re + " + " + this.im + "i";
  }

  public static void main(final String[] args) {
    Executor.execute(Complex.class, args);

    final Complex z0 = new Complex(1.0, 1.0);
    Complex z = z0;
    z = z.times(z)
         .plus(z0);
    z = z.times(z)
         .plus(z0);
    StdOut.println(z);
  }
}

package com.github.mdssjc.algorithms.introcs.chapter3.section33;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.3.1 Complex number (alternate).
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Complex {

  private double r;
  private double theta;

  public Complex(final double re, final double im) {
    this.r = Math.sqrt(re * re + im * im);
    this.theta = Math.atan2(im, re);
  }

  public Complex plus(final Complex b) {
    final double real = re() + b.re();
    final double imag = im() + b.im();
    return new Complex(real, imag);
  }

  public Complex times(final Complex b) {
    final Complex a = this;
    final Complex c = new Complex(0, 0);
    c.r = a.r * b.r;
    c.theta = a.theta + b.theta;
    return c;
  }

  public double abs() {
    return this.r;
  }

  public double re() {
    return this.r * Math.cos(this.theta);
  }

  public double im() {
    return this.r * Math.sin(this.theta);
  }

  @Override
  public String toString() {
    return re() + " + " + im() + "i";
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

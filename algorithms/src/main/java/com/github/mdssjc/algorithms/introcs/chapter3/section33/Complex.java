package com.github.mdssjc.algorithms.introcs.chapter3.section33;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.3.1 Complex number (alternate).
 * <p>
 * Compilation:  javac Complex.java
 * Execution:    java Complex
 * <p>
 * ADT for complex numbers using polar representation.
 * <p>
 * % java Complex
 * a = 5.0 + 6.0i
 * b = -2.0000000000000004 + 2.9999999999999996i
 * c = -27.999999999999996 + 2.9999999999999876i
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

  public double re() { return this.r * Math.cos(this.theta); }
  public double im() { return this.r * Math.sin(this.theta); }

  @Override
  public String toString()  {
    return re() + " + " + im() + "i";
  }

  public Complex plus(final Complex b) {
    final var a = this;
    final var re = a.r * Math.cos(a.theta) + b.r * Math.cos(b.theta);
    final var im = a.r * Math.sin(a.theta) + b.r * Math.sin(b.theta);
    return new Complex(re, im);
  }

  public Complex times(final Complex b) {
    final var a = this;
    final var c = new Complex(0, 0);
    c.r = a.r * b.r;
    c.theta = a.theta + b.theta;
    return c;
  }

  public double abs() { return this.r; }

  public static void main(final String[] args) {
    Executor.execute(Complex.class, args);

    final var a = new Complex(5.0, 6.0);
    StdOut.println("a = " + a);

    final var b = new Complex(-2.0, 3.0);
    StdOut.println("b = " + b);

    final var c = b.times(a);
    StdOut.println("c = " + c);
  }
}

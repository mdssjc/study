package com.github.mdssjc.algorithms.introcs.chapter3.section33;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.3.3 Spatial vectors.
 * <p>
 * Compilation:  javac Vector.java
 * Execution:    java Vector
 * <p>
 * Implementation of a vector of real numbers.
 * <p>
 * This class is implemented to be immutable: once the client program
 * initialize a Vector, it cannot change any of its fields
 * (N or data[i]) either directly or indirectly. Immutability is a
 * very desirable feature of a data type.
 * <p>
 * <p>
 * % java Vector
 * x        =  (1.0, 2.0, 3.0, 4.0)
 * y        =  (5.0, 2.0, 4.0, 1.0)
 * x + y    =  (6.0, 4.0, 7.0, 5.0)
 * 10x      =  (10.0, 20.0, 30.0, 40.0)
 * |x|      =  5.477225575051661
 * <x, y>   =  25.0
 * |x - y|  =  5.0990195135927845
 * <p>
 * Note that java.util.Vector is an unrelated Java library class.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Vector {

  private final int n;
  private final double[] data;

  public Vector(final int n) {
    this.n = n;
    this.data = new double[n];
  }

  public Vector(final double[] data) {
    this.n = data.length;

    this.data = new double[this.n];
    for (var i = 0; i < this.n; i++) {
      this.data[i] = data[i];
    }
  }

  public int length() {
    return this.n;
  }

  public double dot(final Vector that) {
    if (this.length() != that.length()) {
      throw new IllegalArgumentException("dimensions disagree");
    }
    var sum = 0.0;
    for (var i = 0; i < this.n; i++) {
      sum += (this.data[i] * that.data[i]);
    }
    return sum;
  }

  public double magnitude() {
    return Math.sqrt(this.dot(this));
  }

  public double distanceTo(final Vector that) {
    if (this.length() != that.length()) {
      throw new IllegalArgumentException("dimensions disagree");
    }
    return this.minus(that)
               .magnitude();
  }

  public Vector plus(final Vector that) {
    if (this.length() != that.length()) {
      throw new IllegalArgumentException("dimensions disagree");
    }
    final var c = new Vector(this.n);
    for (var i = 0; i < this.n; i++) {
      c.data[i] = this.data[i] + that.data[i];
    }
    return c;
  }

  public Vector minus(final Vector that) {
    if (this.length() != that.length()) {
      throw new IllegalArgumentException("dimensions disagree");
    }
    final var c = new Vector(this.n);
    for (var i = 0; i < this.n; i++) {
      c.data[i] = this.data[i] - that.data[i];
    }
    return c;
  }

  public double cartesian(final int i) {
    return this.data[i];
  }

  @Deprecated
  public Vector times(final double factor) {
    final var c = new Vector(this.n);
    for (var i = 0; i < this.n; i++) {
      c.data[i] = factor * this.data[i];
    }
    return c;
  }

  public Vector scale(final double factor) {
    final var c = new Vector(this.n);
    for (var i = 0; i < this.n; i++) {
      c.data[i] = factor * this.data[i];
    }
    return c;
  }

  public Vector direction() {
    if (this.magnitude() == 0.0) {
      throw new ArithmeticException("zero-vector has no direction");
    }
    return this.times(1.0 / this.magnitude());
  }

  @Override
  public String toString() {
    final var s = new StringBuilder();
    s.append('(');
    for (var i = 0; i < this.n; i++) {
      s.append(this.data[i]);
      if (i < this.n - 1) {
        s.append(", ");
      }
    }
    s.append(')');
    return s.toString();
  }

  public static void main(final String[] args) {
    Executor.execute(Vector.class, args);

    final double[] xdata = {1.0, 2.0, 3.0, 4.0};
    final double[] ydata = {5.0, 2.0, 4.0, 1.0};

    final var x = new Vector(xdata);
    final var y = new Vector(ydata);

    StdOut.println("x        =  " + x);
    StdOut.println("y        =  " + y);
    StdOut.println("x + y    =  " + x.plus(y));
    StdOut.println("10x      =  " + x.times(10.0));
    StdOut.println("|x|      =  " + x.magnitude());
    StdOut.println("<x, y>   =  " + x.dot(y));
    StdOut.println("|x - y|  =  " + x.minus(y)
                                     .magnitude());
  }
}

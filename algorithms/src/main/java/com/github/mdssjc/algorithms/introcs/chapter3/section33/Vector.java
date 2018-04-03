package com.github.mdssjc.algorithms.introcs.chapter3.section33;

/**
 * Program 3.3.3 Spatial vectors.
 *
 * @author Marcelo dos Santos
 *
 */
public class Vector {

  private final double[] coords;

  public Vector(final double[] a) {
    this.coords = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      this.coords[i] = a[i];
    }
  }

  public Vector plus(final Vector that) {
    final double[] result = new double[this.coords.length];
    for (int i = 0; i < this.coords.length; i++) {
      result[i] = this.coords[i] + that.coords[i];
    }
    return new Vector(result);
  }

  public Vector scale(final double alpha) {
    final double[] result = new double[this.coords.length];
    for (int i = 0; i < this.coords.length; i++) {
      result[i] = alpha * this.coords[i];
    }
    return new Vector(result);
  }

  public double dot(final Vector that) {
    double sum = 0.0;
    for (int i = 0; i < this.coords.length; i++) {
      sum += this.coords[i] * that.coords[i];
    }
    return sum;
  }

  public double magnitude() {
    return Math.sqrt(this.dot(this));
  }

  public Vector direction() {
    return this.scale(1 / this.magnitude());
  }

  public double cartesian(final int i) {
    return this.coords[i];
  }

  @Override
  public String toString() {
    final StringBuilder s = new StringBuilder();
    s.append('(');
    for (int i = 0; i < this.coords.length; i++) {
      s.append(String.format("%.3f", this.coords[i]));
      if (i < this.coords.length - 1) {
        s.append(", ");
      }
    }
    s.append(')');
    return s.toString();
  }
}

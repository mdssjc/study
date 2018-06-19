package com.github.mdssjc.algorithms.chapter1.section0;

/**
 * 2d interval.
 * <p>
 * Compilation:  javac Interval2D.java
 * Execution:    java Interval2D
 * Dependencies: StdOut.java Interval1D.java StdDraw.java
 * <p>
 * 2-dimensional interval data type.
 *
 * @author Marcelo dos Santos
 *
 */
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

/**
 * The {@code Interval2D} class represents a closed two-dimensional interval,
 * which represents all points (x, y) with both {@code xmin <= x <= xmax} and
 * {@code ymin <= y <= ymax}.
 * Two-dimensional intervals are immutable: their values cannot be changed
 * after they are created.
 * The class {@code Interval2D} includes methods for checking whether
 * a two-dimensional interval contains a point and determining whether
 * two two-dimensional intervals intersect.
 * <p>
 * For additional documentation,
 * see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 * <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 * @author Robert Sedgewick
 * @author Kevin Wayne
 */
@TestDrive({".2", ".5", ".5", ".6", "10000"})
public class Interval2D {

  private final Interval1D x;
  private final Interval1D y;

  /**
   * Initializes a two-dimensional interval.
   *
   * @param x
   *     the one-dimensional interval of x-coordinates
   * @param y
   *     the one-dimensional interval of y-coordinates
   */
  public Interval2D(final Interval1D x, final Interval1D y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Does this two-dimensional interval intersect that two-dimensional interval?
   *
   * @param that
   *     the other two-dimensional interval
   *
   * @return true if this two-dimensional interval intersects
   * that two-dimensional interval; false otherwise
   */
  public boolean intersects(final Interval2D that) {
    if (!this.x.intersects(that.x)) {
      return false;
    }
    if (!this.y.intersects(that.y)) {
      return false;
    }
    return true;
  }

  /**
   * Does this two-dimensional interval contain the point p?
   *
   * @param p
   *     the two-dimensional point
   *
   * @return true if this two-dimensional interval contains the point p; false otherwise
   */
  public boolean contains(final Point2D p) {
    return this.x.contains(p.x()) && this.y.contains(p.y());
  }

  /**
   * Returns the area of this two-dimensional interval.
   *
   * @return the area of this two-dimensional interval
   */
  public double area() {
    return this.x.length() * this.y.length();
  }

  /**
   * Returns a string representation of this two-dimensional interval.
   *
   * @return a string representation of this two-dimensional interval
   * in the form [xmin, xmax] x [ymin, ymax]
   */
  @Override
  public String toString() {
    return this.x + " x " + this.y;
  }

  /**
   * Does this interval equal the other interval?
   *
   * @param other
   *     the other interval
   *
   * @return true if this interval equals the other interval; false otherwise
   */
  @Override
  public boolean equals(final Object other) {
    if (other == this) {
      return true;
    }
    if (other == null) {
      return false;
    }
    if (other.getClass() != this.getClass()) {
      return false;
    }
    final var that = (Interval2D) other;
    return this.x.equals(that.x) && this.y.equals(that.y);
  }

  /**
   * Returns an integer hash code for this interval.
   *
   * @return an integer hash code for this interval
   */
  @Override
  public int hashCode() {
    final var hash1 = this.x.hashCode();
    final var hash2 = this.y.hashCode();
    return 31 * hash1 + hash2;
  }

  /**
   * Draws this two-dimensional interval to standard draw.
   */
  public void draw() {
    final var xc = (this.x.min() + this.x.max()) / 2.0;
    final var yc = (this.y.min() + this.y.max()) / 2.0;
    StdDraw.rectangle(xc, yc, this.x.length() / 2.0, this.y.length() / 2.0);
  }

  /**
   * Unit tests the {@code Interval2D} data type.
   *
   * @param args
   *     the command-line arguments
   */
  public static void main(final String[] args) {
    Executor.execute(Interval2D.class, args);

    final var xmin = Double.parseDouble(args[0]);
    final var xmax = Double.parseDouble(args[1]);
    final var ymin = Double.parseDouble(args[2]);
    final var ymax = Double.parseDouble(args[3]);
    final var trials = Integer.parseInt(args[4]);

    final var xInterval = new Interval1D(xmin, xmax);
    final var yInterval = new Interval1D(ymin, ymax);
    final var box = new Interval2D(xInterval, yInterval);
    box.draw();

    final var counter = new Counter("hits");
    for (var t = 0; t < trials; t++) {
      final var x = StdRandom.uniform(0.0, 1.0);
      final var y = StdRandom.uniform(0.0, 1.0);
      final var point = new Point2D(x, y);

      if (box.contains(point)) {
        counter.increment();
      } else {
        point.draw();
      }
    }

    StdOut.println(counter);
    StdOut.printf("box area = %.2f%n", box.area());
  }
}

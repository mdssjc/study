package com.github.mdssjc.algorithms.chapter1.section0;

/**
 * Axis-aligned rectangle.
 * <p>
 * Compilation:  javac RectHV.java
 * Execution:    none
 * Dependencies: Point2D.java
 * <p>
 * Immutable data type for 2D axis-aligned rectangle.
 *
 * @author Marcelo dos Santos
 *
 */
import edu.princeton.cs.algs4.StdDraw;

/**
 *  The {@code RectHV} class is an immutable data type to encapsulate a
 *  two-dimensional axis-aligned rectagle with real-value coordinates.
 *  The rectangle is <em>closed</em>—it includes the points on the boundary.
 *  <p>
 *  For additional documentation,
 *  see <a href="https://algs4.cs.princeton.edu/12oop">Section 1.2</a> of
 *  <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Robert Sedgewick
 *  @author Kevin Wayne
 */
public final class RectHV {

  private final double xmin;
  private final double ymin;
  private final double xmax;
  private final double ymax;

  /**
   * Initializes a new rectangle [<em>xmin</em>, <em>xmax</em>]
   * x [<em>ymin</em>, <em>ymax</em>].
   *
   * @param  xmin the <em>x</em>-coordinate of the lower-left endpoint
   * @param  xmax the <em>x</em>-coordinate of the upper-right endpoint
   * @param  ymin the <em>y</em>-coordinate of the lower-left endpoint
   * @param  ymax the <em>y</em>-coordinate of the upper-right endpoint
   * @throws IllegalArgumentException if any of {@code xmin},
   *         {@code xmax}, {@code ymin}, or {@code ymax}
   *         is {@code Double.NaN}.
   * @throws IllegalArgumentException if {@code xmax < xmin} or {@code ymax < ymin}.
   */
  public RectHV(final double xmin, final double ymin, final double xmax, final double ymax) {
    this.xmin = xmin;
    this.ymin = ymin;
    this.xmax = xmax;
    this.ymax = ymax;
    if (Double.isNaN(xmin) || Double.isNaN(xmax)) {
      throw new IllegalArgumentException("x-coordinate is NaN: " + toString());
    }
    if (Double.isNaN(ymin) || Double.isNaN(ymax)) {
      throw new IllegalArgumentException("y-coordinate is NaN: " + toString());
    }
    if (xmax < xmin) {
      throw new IllegalArgumentException("xmax < xmin: " + toString());
    }
    if (ymax < ymin) {
      throw new IllegalArgumentException("ymax < ymin: " + toString());
    }
  }

  /**
   * Returns the minimum <em>x</em>-coordinate of any point in this rectangle.
   *
   * @return the minimum <em>x</em>-coordinate of any point in this rectangle
   */
  public double xmin() {
    return this.xmin;
  }

  /**
   * Returns the maximum <em>x</em>-coordinate of any point in this rectangle.
   *
   * @return the maximum <em>x</em>-coordinate of any point in this rectangle
   */
  public double xmax() {
    return this.xmax;
  }

  /**
   * Returns the minimum <em>y</em>-coordinate of any point in this rectangle.
   *
   * @return the minimum <em>y</em>-coordinate of any point in this rectangle
   */
  public double ymin() {
    return this.ymin;
  }

  /**
   * Returns the maximum <em>y</em>-coordinate of any point in this rectangle.
   *
   * @return the maximum <em>y</em>-coordinate of any point in this rectangle
   */
  public double ymax() {
    return this.ymax;
  }

  /**
   * Returns the width of this rectangle.
   *
   * @return the width of this rectangle {@code xmax - xmin}
   */
  public double width() {
    return this.xmax - this.xmin;
  }

  /**
   * Returns the height of this rectangle.
   *
   * @return the height of this rectangle {@code ymax - ymin}
   */
  public double height() {
    return this.ymax - this.ymin;
  }

  /**
   * Returns true if the two rectangles intersect. This includes
   * <em>improper intersections</em> (at points on the boundary
   * of each rectangle) and <em>nested intersctions</em>
   * (when one rectangle is contained inside the other)
   *
   * @param  that the other rectangle
   * @return {@code true} if this rectangle intersect the argument
  rectangle at one or more points
   */
  public boolean intersects(final RectHV that) {
    return this.xmax >= that.xmin && this.ymax >= that.ymin &&
           that.xmax >= this.xmin && that.ymax >= this.ymin;
  }

  /**
   * Returns true if this rectangle contain the point.
   * @param  p the point
   * @return {@code true} if this rectangle contain the point {@code p},
  possibly at the boundary; {@code false} otherwise
   */
  public boolean contains(final Point2D p) {
    return (p.x() >= this.xmin) && (p.x() <= this.xmax) &&
           (p.y() >= this.ymin) && (p.y() <= this.ymax);
  }

  /**
   * Returns the Euclidean distance between this rectangle and the point {@code p}.
   *
   * @param  p the point
   * @return the Euclidean distance between the point {@code p} and the closest point
  on this rectangle; 0 if the point is contained in this rectangle
   */
  public double distanceTo(final Point2D p) {
    return Math.sqrt(this.distanceSquaredTo(p));
  }

  /**
   * Returns the square of the Euclidean distance between this rectangle and the point {@code p}.
   *
   * @param  p the point
   * @return the square of the Euclidean distance between the point {@code p} and
   *         the closest point on this rectangle; 0 if the point is contained
   *         in this rectangle
   */
  public double distanceSquaredTo(final Point2D p) {
    var dx = 0.0;
    var dy = 0.0;
    if (p.x() < this.xmin) {
      dx = p.x() - this.xmin;
    } else if (p.x() > this.xmax) {
      dx = p.x() - this.xmax;
    }
    if (p.y() < this.ymin) {
      dy = p.y() - this.ymin;
    } else if (p.y() > this.ymax) {
      dy = p.y() - this.ymax;
    }
    return dx * dx + dy * dy;
  }

  /**
   * Compares this rectangle to the specified rectangle.
   *
   * @param  other the other rectangle
   * @return {@code true} if this rectangle equals {@code other};
   *         {@code false} otherwise
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
    final var that = (RectHV) other;
    if (this.xmin != that.xmin) {
      return false;
    }
    if (this.ymin != that.ymin) {
      return false;
    }
    if (this.xmax != that.xmax) {
      return false;
    }
    if (this.ymax != that.ymax) {
      return false;
    }
    return true;
  }

  /**
   * Returns an integer hash code for this rectangle.
   * @return an integer hash code for this rectangle
   */
  @Override
  public int hashCode() {
    final var hash1 = ((Double) this.xmin).hashCode();
    final var hash2 = ((Double) this.ymin).hashCode();
    final var hash3 = ((Double) this.xmax).hashCode();
    final var hash4 = ((Double) this.ymax).hashCode();
    return 31 * (31 * (31 * hash1 + hash2) + hash3) + hash4;
  }

  /**
   * Returns a string representation of this rectangle.
   *
   * @return a string representation of this rectangle, using the format
   *         {@code [xmin, xmax] x [ymin, ymax]}
   */
  @Override
  public String toString() {
    return "[" + this.xmin + ", " + this.xmax + "] x [" + this.ymin + ", " + this.ymax + "]";
  }

  /**
   * Draws this rectangle to standard draw.
   */
  public void draw() {
    StdDraw.line(this.xmin, this.ymin, this.xmax, this.ymin);
    StdDraw.line(this.xmax, this.ymin, this.xmax, this.ymax);
    StdDraw.line(this.xmax, this.ymax, this.xmin, this.ymax);
    StdDraw.line(this.xmin, this.ymax, this.xmin, this.ymin);
  }
}

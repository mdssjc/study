package com.github.mdssjc.algorithms.introcs.chapter3.section34;

import com.github.mdssjc.algorithms.introcs.chapter3.section33.Vector;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 3.4.1 Gravitational body.
 * <p>
 * Compilation:  javac Body.java
 * Execution:    java Body
 * Dependencies: Vector.java StdDraw.java
 * <p>
 * Implementation of a 2D Body with a position, velocity and mass.
 *
 * @author Marcelo dos Santos
 *
 */
public class Body {

  private Vector r;
  private Vector v;
  private final double mass;

  public Body(final Vector r, final Vector v, final double mass) {
    this.r = r;
    this.v = v;
    this.mass = mass;
  }

  public void move(final Vector f, final double dt) {
    final var a = f.scale(1 / this.mass);
    this.v = this.v.plus(a.scale(dt));
    this.r = this.r.plus(this.v.scale(dt));
  }

  public Vector forceFrom(final Body b) {
    final var a = this;
    final var G = 6.67e-11;
    final var delta = b.r.minus(a.r);
    final var dist = delta.magnitude();
    final var magnitude = (G * a.mass * b.mass) / (dist * dist);
    return delta.direction()
                .scale(magnitude);
  }

  public void draw() {
    StdDraw.setPenRadius(0.025);
    StdDraw.point(this.r.cartesian(0), this.r.cartesian(1));
  }

  public void draw(final double penRadius) {
    StdDraw.setPenRadius(penRadius);
    StdDraw.point(this.r.cartesian(0), this.r.cartesian(1));
  }
}

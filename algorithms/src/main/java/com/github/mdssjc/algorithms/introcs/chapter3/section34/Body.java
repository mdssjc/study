package com.github.mdssjc.algorithms.introcs.chapter3.section34;

import edu.princeton.cs.algs4.Vector;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 3.4.1 Gravitational body.
 *
 * @author Marcelo dos Santos
 *
 */
public class Body {

  private final double mass;
  private Vector r;
  private Vector v;

  public Body(final Vector r0, final Vector v0, final double m0) {
    this.r = r0;
    this.v = v0;
    this.mass = m0;
  }

  public void move(final Vector force, final double dt) {
    final Vector a = force.scale(1 / this.mass);
    this.v = this.v.plus(a.scale(dt));
    this.r = this.r.plus(this.v.scale(dt));
  }

  public Vector forceFrom(final Body b) {
    final Body a = this;
    final double G = 6.67e-11;
    final Vector delta = b.r.minus(a.r);
    final double dist = delta.magnitude();
    final double magnitude = (G * a.mass * b.mass) / (dist * dist);
    final Vector force = delta.direction()
                              .scale(magnitude);
    return force;
  }

  public void draw() {
    StdDraw.setPenRadius(0.0125);
    StdDraw.point(this.r.cartesian(0), this.r.cartesian(1));
  }
}

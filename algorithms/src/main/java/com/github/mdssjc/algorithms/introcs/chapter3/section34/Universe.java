package com.github.mdssjc.algorithms.introcs.chapter3.section34;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Vector;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 3.4.2 N-body simulation.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"3body.txt", "20000"})
public class Universe {

  private final int n;
  private final Body[] bodies;

  public Universe(final String filename) {
    final In in = new In(filename);
    this.n = in.readInt();
    final double radius = in.readDouble();
    StdDraw.setXscale(-radius, +radius);
    StdDraw.setYscale(-radius, +radius);
    this.bodies = new Body[this.n];
    for (int i = 0; i < this.n; i++) {
      final double rx = in.readDouble();
      final double ry = in.readDouble();
      final double[] position = {rx, ry};
      final double vx = in.readDouble();
      final double vy = in.readDouble();
      final double[] velocity = {vx, vy};
      final double mass = in.readDouble();
      final Vector r = new Vector(position);
      final Vector v = new Vector(velocity);
      this.bodies[i] = new Body(r, v, mass);
    }
  }

  public void increaseTime(final double dt) {
    final Vector[] f = new Vector[this.n];
    for (int i = 0; i < this.n; i++) {
      f[i] = new Vector(new double[2]);
    }
    for (int i = 0; i < this.n; i++) {
      for (int j = 0; j < this.n; j++) {
        if (i != j) {
          f[i] = f[i].plus(this.bodies[i].forceFrom(this.bodies[j]));
        }
      }
    }
    for (int i = 0; i < this.n; i++) {
      this.bodies[i].move(f[i], dt);
    }
  }

  public void draw() {
    for (int i = 0; i < this.n; i++) {
      this.bodies[i].draw();
    }
  }

  public static void main(final String[] args) {
    Executor.execute(Universe.class, args);

    final Universe newton = new Universe(args[0]);
    final double dt = Double.parseDouble(args[1]);
    StdDraw.enableDoubleBuffering();
    while (true) {
      StdDraw.clear();
      newton.increaseTime(dt);
      newton.draw();
      StdDraw.show();
      StdDraw.pause(20);
    }
  }
}

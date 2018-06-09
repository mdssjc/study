package com.github.mdssjc.algorithms.introcs.chapter3.section34;

import com.github.mdssjc.algorithms.introcs.chapter3.section33.Vector;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdIn;

/**
 * Program 3.4.2 N-body simulation.
 * <p>
 * Compilation:  javac Universe.java
 * Execution:    java Universe dt < input.txt
 * Dependencies: Body.java Vector.java StdIn.java StdDraw.java
 * Datafiles:    http://www.cs.princeton.edu/introcs/34nbody/2body.txt
 *               http://www.cs.princeton.edu/introcs/34nbody/3body.txt
 *               http://www.cs.princeton.edu/introcs/34nbody/4body.txt
 *               http://www.cs.princeton.edu/introcs/34nbody/2bodyTiny.txt
 * <p>
 * This data-driven program simulates motion in the universe defined
 * by the standard input stream, increasing time at the rate on the
 * command line.
 * <p>
 * %  java Universe 25000 < 4body.txt
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "25000", input = "4body.txt", inputFile = true)
public class Universe {

  private final int n;
  private final Body[] bodies;

  public Universe() {
    this.n = StdIn.readInt();

    final var radius = StdIn.readDouble();
    StdDraw.setXscale(-radius, +radius);
    StdDraw.setYscale(-radius, +radius);

    this.bodies = new Body[this.n];
    for (var i = 0; i < this.n; i++) {
      final var rx = StdIn.readDouble();
      final var ry = StdIn.readDouble();
      final var vx = StdIn.readDouble();
      final var vy = StdIn.readDouble();
      final var mass = StdIn.readDouble();
      final double[] position = {rx, ry};
      final double[] velocity = {vx, vy};
      final var r = new Vector(position);
      final var v = new Vector(velocity);
      this.bodies[i] = new Body(r, v, mass);
    }
  }

  public void increaseTime(final double dt) {
    final var f = new Vector[this.n];
    for (var i = 0; i < this.n; i++) {
      f[i] = new Vector(new double[2]);
    }

    for (var i = 0; i < this.n; i++) {
      for (var j = 0; j < this.n; j++) {
        if (i != j) {
          f[i] = f[i].plus(this.bodies[i].forceFrom(this.bodies[j]));
        }
      }
    }

    for (var i = 0; i < this.n; i++) {
      this.bodies[i].move(f[i], dt);
    }
  }

  public void draw() {
    for (var i = 0; i < this.n; i++) {
      this.bodies[i].draw();
    }
  }

  public static void main(final String[] args) {
    Executor.execute(Universe.class, args);

    final var newton = new Universe();
    final var dt = Double.parseDouble(args[0]);
    StdDraw.enableDoubleBuffering();
    while (true) {
      StdDraw.clear();
      newton.increaseTime(dt);
      newton.draw();
      StdDraw.show();
      StdDraw.pause(10);
    }
  }
}

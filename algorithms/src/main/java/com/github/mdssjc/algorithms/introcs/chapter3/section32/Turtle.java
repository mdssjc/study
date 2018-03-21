package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 3.2.4 Turtle graphics.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("3")
@TestDrive("7")
@TestDrive("1000")
public class Turtle {

  private double x, y;
  private double angle;

  public Turtle(final double x0, final double y0, final double a0) {
    this.x = x0;
    this.y = y0;
    this.angle = a0;
  }

  public void turnLeft(final double delta) {
    this.angle += delta;
  }

  public void goForward(final double step) {
    final double oldx = this.x;
    final double oldy = this.y;
    this.x += step * Math.cos(Math.toRadians(this.angle));
    this.y += step * Math.sin(Math.toRadians(this.angle));
    StdDraw.line(oldx, oldy, this.x, this.y);
  }

  public static void main(final String[] args) {
    Executor.execute(Turtle.class, args);

    final int n = Integer.parseInt(args[0]);
    final double angle = 360.0 / n;
    final double step = Math.sin(Math.toRadians(angle / 2));
    final Turtle turtle = new Turtle(0.5, 0.0, angle / 2);
    for (int i = 0; i < n; i++) {
      turtle.goForward(step);
      turtle.turnLeft(angle);
    }
  }
}

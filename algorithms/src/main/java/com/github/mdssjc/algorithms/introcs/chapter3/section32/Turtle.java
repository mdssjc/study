package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

/**
 * Program 3.2.4 Turtle graphics.
 * <p>
 * Compilation:  javac Turtle.java
 * Execution:    java Turtle
 * <p>
 * Data type for turtle graphics using standard draw.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class Turtle {

  private double x;
  private double y;
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
    final var oldx = this.x;
    final var oldy = this.y;
    this.x += step * Math.cos(Math.toRadians(this.angle));
    this.y += step * Math.sin(Math.toRadians(this.angle));
    StdDraw.line(oldx, oldy, this.x, this.y);
  }

  public void show() {
    StdDraw.show();
  }

  public void pause(final int t) {
    StdDraw.pause(t);
  }

  public void setPenColor(final Color color) {
    StdDraw.setPenColor(color);
  }

  public void setPenRadius(final double radius) {
    StdDraw.setPenRadius(radius);
  }

  public void setCanvasSize(final int width, final int height) {
    StdDraw.setCanvasSize(width, height);
  }

  public void setXscale(final double min, final double max) {
    StdDraw.setXscale(min, max);
  }

  public void setYscale(final double min, final double max) {
    StdDraw.setYscale(min, max);
  }

  public static void main(final String[] args) {
    Executor.execute(Turtle.class, args);

    StdDraw.enableDoubleBuffering();
    final var x0 = 0.5;
    final var y0 = 0.0;
    final var a0 = 60.0;
    final var step = Math.sqrt(3) / 2;
    final var turtle = new Turtle(x0, y0, a0);
    turtle.goForward(step);
    turtle.turnLeft(120.0);
    turtle.goForward(step);
    turtle.turnLeft(120.0);
    turtle.goForward(step);
    turtle.turnLeft(120.0);
  }
}

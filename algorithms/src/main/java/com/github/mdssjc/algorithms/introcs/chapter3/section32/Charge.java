package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.2.1 Charged particle.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive({"0.2", "0.5"})
@TestDrive({"0.51", "0.94"})
public class Charge {

  private final double rx, ry;
  private final double q;

  public Charge(final double x0, final double y0, final double q0) {
    this.rx = x0;
    this.ry = y0;
    this.q = q0;
  }

  public double potentialAt(final double x, final double y) {
    final double k = 8.99e09;
    final double dx = x - this.rx;
    final double dy = y - this.ry;
    return k * this.q / Math.sqrt(dx * dx + dy * dy);
  }

  @Override
  public String toString() {
    return this.q + " at (" + this.rx + ", " + this.ry + ")";
  }

  public static void main(final String[] args) {
    Executor.execute(Charge.class, args);

    final double x = Double.parseDouble(args[0]);
    final double y = Double.parseDouble(args[1]);
    final Charge c1 = new Charge(0.51, 0.63, 21.3);
    final Charge c2 = new Charge(0.13, 0.94, 81.9);
    StdOut.println(c1);
    StdOut.println(c2);
    final double v1 = c1.potentialAt(x, y);
    final double v2 = c2.potentialAt(x, y);
    StdOut.printf("%.2e%n", (v1 + v2));
  }
}

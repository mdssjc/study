package com.github.mdssjc.algorithms.introcs.chapter3.section33;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.3.4 Document sketch.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"2", "16"}, input = "genome20.txt", inputFile = true)
public class Sketch {

  private final Vector profile;

  public Sketch(final String text, final int k, final int d) {
    final int n = text.length();
    final double[] freq = new double[d];
    for (int i = 0; i < n - k - 1; i++) {
      final String kgram = text.substring(i, i + k);
      final int hash = kgram.hashCode();
      freq[Math.abs(hash % d)] += 1;
    }
    final Vector vector = new Vector(freq);
    this.profile = vector.direction();
  }

  public double similarTo(final Sketch other) {
    return this.profile.dot(other.profile);
  }

  @Override
  public String toString() {
    return "" + this.profile;
  }

  public static void main(final String[] args) {
    Executor.execute(Sketch.class, args);

    final int k = Integer.parseInt(args[0]);
    final int d = Integer.parseInt(args[1]);
    final String text = StdIn.readAll();
    final Sketch sketch = new Sketch(text, k, d);
    StdOut.println(sketch);
  }
}

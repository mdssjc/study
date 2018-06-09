package com.github.mdssjc.algorithms.introcs.chapter3.section33;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdIn;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.3.4 Document sketch.
 * <p>
 * Compilation:  javac Sketch.java
 * Execution:    java Sketch k d < input.txt
 * Data files:   http://www.cs.princeton.edu/introcs/33design/genome20.txt
 * http://www.cs.princeton.edu/introcs/33design/genome50.txt
 * <p>
 * % java Sketch 2 16 < genome20.txt
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = {"2", "16"}, input = "genome20.txt", inputFile = true)
public class Sketch {

  private final Vector profile;

  public Sketch(final String text, final int k, final int d) {
    final var n = text.length();
    final var freq = new double[d];
    for (var i = 0; i < n - k + 1; i++) {
      final var kgram = text.substring(i, i + k);
      final var hash = kgram.hashCode();
      freq[Math.abs(hash % d)] += 1;
    }
    final var vector = new Vector(freq);
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

    final var k = Integer.parseInt(args[0]);
    final var d = Integer.parseInt(args[1]);
    final var text = StdIn.readAll();
    final var sketch = new Sketch(text, k, d);
    StdOut.println(sketch);
  }
}

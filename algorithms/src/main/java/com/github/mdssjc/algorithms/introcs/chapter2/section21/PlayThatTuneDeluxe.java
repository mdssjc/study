package com.github.mdssjc.algorithms.introcs.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdIn;

/**
 * Program 2.1.4 Play that tune (revisited).
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "elise.txt", inputFile = true)
public class PlayThatTuneDeluxe {

  public static double[] superpose(final double[] a, final double[] b,
                                   final double awt, final double bwt) {
    final double[] c = new double[a.length];
    for (int i = 0; i < a.length; i++) {
      c[i] = a[i] * awt + b[i] * bwt;
    }
    return c;
  }

  public static double[] tone(final double hz, final double t) {
    final int SAMPLING_RATE = 44100;
    final int n = (int) (SAMPLING_RATE * t);
    final double[] a = new double[n + 1];
    for (int i = 0; i <= n; i++) {
      a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);
    }
    return a;
  }

  public static double[] note(final int pitch, final double t) {
    final double hz = 440.0 * Math.pow(2, pitch / 12.0);
    final double[] a = tone(hz, t);
    final double[] hi = tone(2 * hz, t);
    final double[] lo = tone(hz / 2, t);
    final double[] h = superpose(hi, lo, 0.5, 0.5);
    return superpose(a, h, 0.5, 0.5);
  }

  public static void main(final String[] args) {
    Executor.execute(PlayThatTuneDeluxe.class, args);

    while (!StdIn.isEmpty()) {
      final int pitch = StdIn.readInt();
      final double duration = StdIn.readDouble();
      final double[] a = note(pitch, duration);
      StdAudio.play(a);
    }
  }
}

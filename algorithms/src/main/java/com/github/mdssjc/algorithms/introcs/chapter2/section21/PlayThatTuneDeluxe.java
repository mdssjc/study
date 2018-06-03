package com.github.mdssjc.algorithms.introcs.chapter2.section21;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdIn;

/**
 * Program 2.1.4 Play that tune (revisited).
 * <p>
 * Compilation:  javac PlayThatTuneDeluxe.java
 * Execution:    java PlayThatTuneDeluxe < data.txt
 * <p>
 * % java PlayThatTuneDeluxe 0.5 < elise.txt
 * <p>
 * Data files
 * ----------
 * http://www.cs.princeton.edu/introcs/21function/elise.txt
 * http://www.cs.princeton.edu/introcs/21function/freebird.txt
 * http://www.cs.princeton.edu/introcs/21function/Ascale.txt
 * http://www.cs.princeton.edu/introcs/21function/National_Anthem.txt
 * http://www.cs.princeton.edu/introcs/21function/looney.txt
 * http://www.cs.princeton.edu/introcs/21function/StairwayToHeaven.txt
 * http://www.cs.princeton.edu/introcs/21function/entertainer.txt
 * http://www.cs.princeton.edu/introcs/21function/old-nassau.txt
 * http://www.cs.princeton.edu/introcs/21function/arabesque.txt
 * http://www.cs.princeton.edu/introcs/21function/firstcut.txt
 * http://www.cs.princeton.edu/introcs/21function/tomsdiner.txt
 * http://www.cs.princeton.edu/introcs/21function/portal.txt
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "0.5", input = "elise.txt", inputFile = true)
public class PlayThatTuneDeluxe {

  public static double[] sum(final double[] a, final double[] b, final double awt, final double bwt) {
    assert a.length == b.length;

    final var c = new double[a.length];
    for (var i = 0; i < a.length; i++) {
      c[i] = a[i] * awt + b[i] * bwt;
    }
    return c;
  }

  public static double[] tone(final double hz, final double duration) {
    final var n = (int) (StdAudio.SAMPLE_RATE * duration);
    final var a = new double[n + 1];
    for (var i = 0; i <= n; i++) {
      a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
    }
    return a;
  }

  public static double[] note(final int pitch, final double duration) {
    final var hz = 440.0 * Math.pow(2, pitch / 12.0);
    final var a = tone(hz, duration);
    final var hi = tone(2 * hz, duration);
    final var lo = tone(hz / 2, duration);
    final var h = sum(hi, lo, 0.5, 0.5);
    return sum(a, h, 0.5, 0.5);
  }

  public static void main(final String[] args) {
    Executor.execute(PlayThatTuneDeluxe.class, args);

    while (!StdIn.isEmpty()) {
      final var pitch = StdIn.readInt();
      final var duration = StdIn.readDouble();
      final var a = note(pitch, duration);
      StdAudio.play(a);
    }
  }
}

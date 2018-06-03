package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdIn;

/**
 * Program 1.5.7 Digital signal processing.
 * <p>
 * Compilation:  javac PlayThatTune.java
 * Execution:    java PlayThatTune < input.txt
 * Dependencies: StdAudio.java StdAudio.java
 * <p>
 * This is a data-driven program that plays pure tones from
 * the notes on the chromatic scale, specified on standard input
 * by their distance from concert A.
 * <p>
 * % java PlayThatTune < elise.txt
 * <p>
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
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "elise.txt", inputFile = true)
public class PlayThatTune {

  public static void main(final String[] args) {
    Executor.execute(PlayThatTune.class, args);

    while (!StdIn.isEmpty()) {
      final var pitch = StdIn.readInt();

      final var duration = StdIn.readDouble();

      final var hz = 440 * Math.pow(2, pitch / 12.0);
      final var n = (int) (StdAudio.SAMPLE_RATE * duration);
      final var a = new double[n + 1];
      for (var i = 0; i <= n; i++) {
        a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
      }

      StdAudio.play(a);
    }
  }
}

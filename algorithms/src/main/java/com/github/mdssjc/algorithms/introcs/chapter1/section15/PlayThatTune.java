package com.github.mdssjc.algorithms.introcs.chapter1.section15;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdAudio;
import edu.princeton.cs.introcs.StdIn;

/**
 * Program 1.5.7 Digital signal processing.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(input = "elise.txt", inputFile = true)
public class PlayThatTune {

  public static void main(final String[] args) {
    Executor.execute(PlayThatTune.class, args);

    final int SAMPLING_RATE = 44100;

    while (!StdIn.isEmpty()) {
      final int pitch = StdIn.readInt();
      final double duration = StdIn.readDouble();
      final double hz = 440 * Math.pow(2, pitch / 12.0);
      final int n = (int) (SAMPLING_RATE * duration);
      final double[] a = new double[n + 1];

      for (int i = 0; i <= n; i++) {
        a[i] = Math.sin(2 * Math.PI * i * hz / SAMPLING_RATE);
      }
      StdAudio.play(a);
    }
  }
}

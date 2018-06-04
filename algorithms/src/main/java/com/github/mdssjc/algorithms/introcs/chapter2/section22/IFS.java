package com.github.mdssjc.algorithms.introcs.chapter2.section22;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.StdDraw;

/**
 * Program 2.2.3 Iterated function systems.
 * <p>
 * Compilation:  javac IFS.java
 * Execution:    java IFS trials < input.txt
 * Dependencies: StdDraw.java
 * <p>
 * Here are some sample data files:
 * <p>
 * http://www.cs.princeton.edu/introcs/22library/barnsley.txt
 * http://www.cs.princeton.edu/introcs/22library/binary.txt
 * http://www.cs.princeton.edu/introcs/22library/culcita.txt
 * http://www.cs.princeton.edu/introcs/22library/cyclosorus.txt
 * http://www.cs.princeton.edu/introcs/22library/dragon.txt
 * http://www.cs.princeton.edu/introcs/22library/fern-sedgewick.txt
 * http://www.cs.princeton.edu/introcs/22library/fishbone.txt
 * http://www.cs.princeton.edu/introcs/22library/floor.txt
 * http://www.cs.princeton.edu/introcs/22library/koch.txt
 * http://www.cs.princeton.edu/introcs/22library/sierpinski.txt
 * http://www.cs.princeton.edu/introcs/22library/spiral.txt
 * http://www.cs.princeton.edu/introcs/22library/swirl.txt
 * http://www.cs.princeton.edu/introcs/22library/tree.txt
 * http://www.cs.princeton.edu/introcs/22library/zigzag.txt
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "10000", input = "sierpinski.txt", inputFile = true)
@TestDrive(value = "20000", input = "barnsley.txt", inputFile = true)
@TestDrive(value = "20000", input = "tree.txt", inputFile = true)
@TestDrive(value = "20000", input = "coral.txt", inputFile = true)
public class IFS {

  public static void main(final String[] args) {
    Executor.execute(IFS.class, args);

    final var trials = Integer.parseInt(args[0]);

    final var dist = StdArrayIO.readDouble1D();

    final var cx = StdArrayIO.readDouble2D();
    final var cy = StdArrayIO.readDouble2D();

    var x = 0.0;
    var y = 0.0;

    StdDraw.enableDoubleBuffering();
    for (var t = 0; t < trials; t++) {
      final var r = StdRandom.discrete(dist);

      final var x0 = cx[r][0] * x + cx[r][1] * y + cx[r][2];
      final var y0 = cy[r][0] * x + cy[r][1] * y + cy[r][2];
      x = x0;
      y = y0;

      StdDraw.point(x, y);

      if (t % 100 == 0) {
        StdDraw.show();
        StdDraw.pause(10);
      }
    }

    StdDraw.show();
  }
}

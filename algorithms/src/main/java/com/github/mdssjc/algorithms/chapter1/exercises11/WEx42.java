package com.github.mdssjc.algorithms.chapter1.exercises11;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdDraw;

/**
 * Web Exercise 42.
 * <p>
 * Right triangle.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class WEx42 {

  public static void main(final String[] args) {
    Executor.execute(WEx42.class, args);

    StdDraw.square(.5, .5, .5);
    StdDraw.setPenColor(StdDraw.BLUE);
    StdDraw.line(.5, .5, .9, .5);
    StdDraw.line(.9, .5, .5, .8);
    StdDraw.line(.5, .8, .5, .5);
    StdDraw.circle(.7, .65, .25);
  }
}

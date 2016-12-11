package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 16.
 * <p>
 * RationalCEx16 numbers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx16 {

  public static void main(final String[] args) {
    Executor.execute(CEx16.class, args);

    RationalCEx16 x;
    RationalCEx16 y;
    RationalCEx16 z;

    // 1/2 + 1/3 = 5/6
    x = new RationalCEx16(1, 2);
    y = new RationalCEx16(1, 3);
    z = x.plus(y);
    StdOut.println(z);

    // 8/9 + 1/9 = 1
    x = new RationalCEx16(8, 9);
    y = new RationalCEx16(1, 9);
    z = x.plus(y);
    StdOut.println(z);

    //  4/17 * 7/3 = 28/51
    x = new RationalCEx16(4, 17);
    y = new RationalCEx16(7, 3);
    z = x.times(y);
    StdOut.println(z);

    // 203/16957 * 9299/5887 = 17/899
    x = new RationalCEx16(203, 16957);
    y = new RationalCEx16(9299, 5887);
    z = x.times(y);
    StdOut.println(z);

    // 3/5 / 1/2 = 6/5
    x = new RationalCEx16(3, 5);
    y = new RationalCEx16(1, 2);
    z = x.dividedBy(y);
    StdOut.println(z);

    // 1/6 - -4/-8 = -1/3
    x = new RationalCEx16(1, 6);
    y = new RationalCEx16(-4, -8);
    z = x.minus(y);
    StdOut.println(z);

    // 0/6 = 0
    x = new RationalCEx16(0, 6);
    StdOut.println(x);
  }
}

package com.github.mdssjc.algorithms.chapter1.exercises12;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

/**
 * Creative Exercise 17.
 * <p>
 * Robust implementation of rational numbers.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive
public class CEx17 {

  public static void main(final String[] args) {
    Executor.execute(CEx17.class, args);

    RationalCEx17 x;
    RationalCEx17 y;
    RationalCEx17 z;

    // 1/2 + 1/3 = 5/6
    x = new RationalCEx17(1, 2);
    y = new RationalCEx17(1, 3);
    z = x.plus(y);
    StdOut.println(z);

    // 8/9 + 1/9 = 1
    x = new RationalCEx17(8, 9);
    y = new RationalCEx17(1, 9);
    z = x.plus(y);
    StdOut.println(z);

    //  4/17 * 7/3 = 28/51
    x = new RationalCEx17(4, 17);
    y = new RationalCEx17(7, 3);
    z = x.times(y);
    StdOut.println(z);

    // 203/16957 * 9299/5887 = 17/899
    x = new RationalCEx17(203, 16957);
    y = new RationalCEx17(9299, 5887);
    z = x.times(y);
    StdOut.println(z);

    // 3/5 / 1/2 = 6/5
    x = new RationalCEx17(3, 5);
    y = new RationalCEx17(1, 2);
    z = x.dividedBy(y);
    StdOut.println(z);

    // 1/6 - -4/-8 = -1/3
    x = new RationalCEx17(1, 6);
    y = new RationalCEx17(-4, -8);
    z = x.minus(y);
    StdOut.println(z);

    // 0/6 = 0
    x = new RationalCEx17(0, 6);
    StdOut.println(x);
  }
}

package com.github.mdssjc.algorithms.chapter2.exercises22;

import com.github.mdssjc.algorithms.sort.concrete.MergeSort;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

/**
 * Exercise 9.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("A E Q S U Y E I N O S T")
public class Ex9 {

  public static void main(final String[] args) {
    Executor.execute(Ex9.class, args);

    final String[] a = args[0].split(" ");
    final String[] b = args[0].split(" ");

    final MergeSort mergeA = new MergeSort(MergeSort.TYPE.TOP_DOWN);
    final MergeSortEx9 mergeB = new MergeSortEx9(MergeSortEx9.TYPE.TOP_DOWN);

    mergeA.sort(a);
    mergeB.sort(b);

    if (Arrays.equals(a, b)) {
      StdOut.println("Ok");
    } else {
      StdOut.println("Fail");
    }
  }
}

package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.queue.Queue;
import com.github.mdssjc.algorithms.datastructure.queue.concrete.ResizingArrayQueue;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Exercise 16.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( input = "7/10/1984 10/10/2010 10/19/2016" )
public class Ex16 {

  public static void main(final String[] args) {
    Executor.execute(Ex16.class, args);

    for (final Date date : readDates()) {
      StdOut.println(date.toString());
    }
  }

  public static Date[] readDates() {
    final Queue<Date> dates = new ResizingArrayQueue<>();
    while (!StdIn.isEmpty()) {
      dates.enqueue(new Date(StdIn.readString()));
    }

    final int n = dates.size();
    final Date[] d = new Date[n];
    for (int i = 0; i < n; i++) {
      d[i] = dates.dequeue();
    }
    return d;
  }
}

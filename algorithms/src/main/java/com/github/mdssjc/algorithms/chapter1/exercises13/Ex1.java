package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercise 1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( "10" )
public class Ex1 {

  public static void main(final String[] args) {
    Executor.execute(Ex1.class, args);

    final int n = Integer.parseInt(args[0]);
    final StackEx1_3<Integer> stack = new StackEx1_3<>(n);

    for (int i = 0; i < n; i++) {
      stack.push(i);
    }

    final boolean result = stack.isFull();
    assert result : "Pilha não está cheia.";
  }
}

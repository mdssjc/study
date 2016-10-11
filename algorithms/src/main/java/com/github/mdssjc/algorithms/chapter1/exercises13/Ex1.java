package com.github.mdssjc.algorithms.chapter1.exercises13;

import com.github.mdssjc.algorithms.datastructure.stack.concrete.FixedCapacityStack;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;

/**
 * Exercício 1.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive( {"10"} )
public class Ex1 {
  public static void main(String[] args) {
    Executor.execute(Ex1.class, args);

    final int n = Integer.parseInt(args[0]);
    FixedCapacityStack<Integer> stack = new FixedCapacityStack<>(n);

    for (int i = 0; i < n; i++) {
      stack.push(i);
    }

    final boolean result = stack.isFull();
    assert result : "Pilha não está cheia.";
  }
}

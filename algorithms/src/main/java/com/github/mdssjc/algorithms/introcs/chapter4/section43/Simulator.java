package com.github.mdssjc.algorithms.introcs.chapter4.section43;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(ArrayStackOfStrings.class, "Program 4.3.1 Stack of strings (array)");
    Executor.execute(LinkedStackOfStrings.class, "Program 4.3.2 Stack of strings (linked list)");
    Executor.execute(ResizingArrayStackOfStrings.class, "Program 4.3.3 Stack of strings (resizing array)");
    Executor.execute(Stack.class, "Program 4.3.4 Generic stack");
    Executor.execute(Evaluate.class, "Program 4.3.5 Expression evaluation");
    Executor.execute(Queue.class, "Program 4.3.6 Generic FIFO queue (linked list)");
    Executor.execute(MM1Queue.class, "Program 4.3.7 M/M/1 queue simulation");
    Executor.execute(LoadBalance.class, "Program 4.3.8 Load balancing simulation");
  }
}

package com.github.mdssjc.design_patterns.structural.facade;

import java.util.Arrays;

/**
 * Subsystem Classes.
 *
 * @author Marcelo dos Santos
 *
 */
public class SubsystemC {

  private static final int LEN = 12;
  private final int[] result;
  private int index;

  public SubsystemC() {
    this.result = new int[LEN];
    this.index = 0;
  }

  public void insert(final int i) {
    this.result[this.index] = i;
    this.index++;
    this.index = this.index % LEN;
  }

  public int doResult() {
    return Arrays.stream(this.result)
                 .sum();
  }
}

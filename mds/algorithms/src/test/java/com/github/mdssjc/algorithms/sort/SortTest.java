package com.github.mdssjc.algorithms.sort;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class SortTest {

  String[] expecteds = { "M", "a", "c", "e", "l", "o", "r" };
  String[] actuals;

  @Before
  public void genArray() {
    this.actuals = "Marcelo".split("");
  }

  @Test
  public void testSelectionSort() {
    SelectionSort.sort(this.actuals);
    assertArrayEquals(this.expecteds, this.actuals);
  }

  @Test
  public void testInsertionSort() {
    InsertionSort.sort(this.actuals);
    assertArrayEquals(this.expecteds, this.actuals);
  }

  @Test
  public void testShellSort() {
    ShellSort.sort(this.actuals);
    assertArrayEquals(this.expecteds, this.actuals);
  }

  @Test
  public void testMergeSort() {
    MergeSort.sort(this.actuals);
    assertArrayEquals(this.expecteds, this.actuals);
  }

  @Test
  public void testQuickSort() {
    QuickSort.sort(this.actuals);
    assertArrayEquals(this.expecteds, this.actuals);
  }
}

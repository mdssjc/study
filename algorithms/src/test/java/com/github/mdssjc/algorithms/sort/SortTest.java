package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.sort.concrete.InsertionSort;
import com.github.mdssjc.algorithms.sort.concrete.SelectionSort;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Sort Test.
 * <p>
 * - numbers
 * - letters
 * - files
 *
 * @author Marcelo dos Santos
 *
 */
public class SortTest {

  final Double[] numbers = new Double[100];
  String[] letters;
  File[] files;

  @Before
  public void generateArray() {
    for (int i = 0; i < 100; i++) {
      this.numbers[i] = StdRandom.uniform();
    }

    this.letters = "Marcelo".split("");

    this.files = new File(".").listFiles();
  }

  @Test
  public void testSelectionSort() {
    final Sort selection = new SelectionSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertTrue(Sort.isSorted(this.numbers));
    assertTrue(Sort.isSorted(this.letters));
    assertTrue(Sort.isSorted(this.files));
  }

  @Test
  public void testInsertionSort() {
    final Sort selection = new InsertionSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertTrue(Sort.isSorted(this.numbers));
    assertTrue(Sort.isSorted(this.letters));
    assertTrue(Sort.isSorted(this.files));
  }

  @Test
  public void testShellSort() {
//    ShellSort.sort(this.numbers);
//    ShellSort.sort(this.letters);
//    ShellSort.sort(this.files);
//
//    assertTrue(Sort.isSorted(this.numbers));
//    assertTrue(Sort.isSorted(this.letters));
//    assertTrue(Sort.isSorted(this.files));
  }

  @Test
  public void testMergeSort() {
//    MergeSort.sort(this.numbers);
//    MergeSort.sort(this.letters);
//    MergeSort.sort(this.files);
//
//    assertTrue(Sort.isSorted(this.numbers));
//    assertTrue(Sort.isSorted(this.letters));
//    assertTrue(Sort.isSorted(this.files));
  }

  @Test
  public void testQuickSort() {
//    QuickSort.sort(this.numbers);
//    QuickSort.sort(this.letters);
//    QuickSort.sort(this.files);
//
//    assertTrue(Sort.isSorted(this.numbers));
//    assertTrue(Sort.isSorted(this.letters));
//    assertTrue(Sort.isSorted(this.files));
  }
}

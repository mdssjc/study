package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.sort.concrete.*;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * Sort Test.
 * <p>
 * - números
 * - letras
 * - arquivos
 *
 * @author Marcelo dos Santos
 *
 */
public class SortTest {

  private final Double[] numbers = new Double[100];
  private String[] letters;
  private File[] files;

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
    final Sort selection = new ShellSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertTrue(Sort.isSorted(this.numbers));
    assertTrue(Sort.isSorted(this.letters));
    assertTrue(Sort.isSorted(this.files));
  }

  @Test
  public void testMergeSort() {
    final Sort selection = new MergeSort(MergeSort.TYPE.TOP_DOWN);

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertTrue(Sort.isSorted(this.numbers));
    assertTrue(Sort.isSorted(this.letters));
    assertTrue(Sort.isSorted(this.files));
  }

  @Test
  public void testQuickSort() {
    final Sort selection = new QuickSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertTrue(Sort.isSorted(this.numbers));
    assertTrue(Sort.isSorted(this.letters));
    assertTrue(Sort.isSorted(this.files));
  }

  @Test
  public void testHeapSort() {
    final Sort selection = new HeapSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertTrue(Sort.isSorted(this.numbers));
    assertTrue(Sort.isSorted(this.letters));
    assertTrue(Sort.isSorted(this.files));
  }
}

package com.github.mdssjc.algorithms.sort;

import com.github.mdssjc.algorithms.sort.concrete.*;
import edu.princeton.cs.algs4.StdRandom;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

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
  private Double[] numbersRef;
  private String[] lettersRef;
  private File[] filesRef;

  @Before
  public void generateArray() {
    for (int i = 0; i < 100; i++) {
      this.numbers[i] = StdRandom.uniform();
    }

    this.letters = "Marcelo".split("");

    this.files = new File(".").listFiles();

    this.numbersRef = Arrays.copyOf(this.numbers, this.numbers.length);
    this.lettersRef = Arrays.copyOf(this.letters, this.letters.length);
    this.filesRef = Arrays.copyOf(this.files, this.files.length);

    Arrays.sort(this.numbersRef);
    Arrays.sort(this.lettersRef);
    Arrays.sort(this.filesRef);
  }

  @Test
  public void testSelectionSort() {
    final Sort selection = new SelectionSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertArrayEquals(this.numbersRef, this.numbers);
    assertArrayEquals(this.lettersRef, this.letters);
    assertArrayEquals(this.filesRef, this.files);
  }

  @Test
  public void testInsertionSort() {
    final Sort selection = new InsertionSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertArrayEquals(this.numbersRef, this.numbers);
    assertArrayEquals(this.lettersRef, this.letters);
    assertArrayEquals(this.filesRef, this.files);
  }

  @Test
  public void testShellSort() {
    final Sort selection = new ShellSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertArrayEquals(this.numbersRef, this.numbers);
    assertArrayEquals(this.lettersRef, this.letters);
    assertArrayEquals(this.filesRef, this.files);
  }

  @Test
  public void testMergeSort() {
    final Sort selection = new MergeSort(MergeSort.TYPE.TOP_DOWN);

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertArrayEquals(this.numbersRef, this.numbers);
    assertArrayEquals(this.lettersRef, this.letters);
    assertArrayEquals(this.filesRef, this.files);
  }

  @Test
  public void testQuickSort() {
    final Sort selection = new QuickSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertArrayEquals(this.numbersRef, this.numbers);
    assertArrayEquals(this.lettersRef, this.letters);
    assertArrayEquals(this.filesRef, this.files);
  }

  @Test
  public void testHeapSort() {
    final Sort selection = new HeapSort();

    selection.sort(this.numbers);
    selection.sort(this.letters);
    selection.sort(this.files);

    assertArrayEquals(this.numbersRef, this.numbers);
    assertArrayEquals(this.lettersRef, this.letters);
    assertArrayEquals(this.filesRef, this.files);
  }
}

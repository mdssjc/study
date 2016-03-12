package com.github.mdssjc.algorithms.sort;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import com.github.mdssjc.algorithms.sort.utils.SortHandles;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Classe de Teste: Sort.
 *
 * - números de ponto decimal;
 * - letras.
 * - arquivos.
 *
 * @author Marcelo dos Santos
 *
 */
public class SortTest {

  final Double[] numbers = new Double[100];
  String[]       letters;
  File[]         files;

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
    SelectionSort.sort(this.numbers);
    SelectionSort.sort(this.letters);
    SelectionSort.sort(this.files);

    assertTrue(SortHandles.isSorted(this.numbers));
    assertTrue(SortHandles.isSorted(this.letters));
    assertTrue(SortHandles.isSorted(this.files));
  }

  @Test
  public void testInsertionSort() {
    InsertionSort.sort(this.numbers);
    InsertionSort.sort(this.letters);
    InsertionSort.sort(this.files);

    assertTrue(SortHandles.isSorted(this.numbers));
    assertTrue(SortHandles.isSorted(this.letters));
    assertTrue(SortHandles.isSorted(this.files));
  }

  @Test
  public void testShellSort() {
    ShellSort.sort(this.numbers);
    ShellSort.sort(this.letters);
    ShellSort.sort(this.files);

    assertTrue(SortHandles.isSorted(this.numbers));
    assertTrue(SortHandles.isSorted(this.letters));
    assertTrue(SortHandles.isSorted(this.files));
  }

  @Test
  public void testMergeSort() {
    MergeSort.sort(this.numbers);
    MergeSort.sort(this.letters);
    MergeSort.sort(this.files);

    assertTrue(SortHandles.isSorted(this.numbers));
    assertTrue(SortHandles.isSorted(this.letters));
    assertTrue(SortHandles.isSorted(this.files));
  }

  @Test
  public void testQuickSort() {
    QuickSort.sort(this.numbers);
    QuickSort.sort(this.letters);
    QuickSort.sort(this.files);

    assertTrue(SortHandles.isSorted(this.numbers));
    assertTrue(SortHandles.isSorted(this.letters));
    assertTrue(SortHandles.isSorted(this.files));
  }
}

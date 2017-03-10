package com.github.mdssjc.algorithms.search.concrete;

import com.github.mdssjc.algorithms.search.BinarySearch;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Teste do Binary Search Iterative.
 *
 * @author Marcelo dos Santos
 *
 */
public class BinarySearchIterativeTest {

  private BinarySearch bs;

  @Before
  public void setup() {
    this.bs = new BinarySearchIterative();
  }

  @Test
  public void buscaOValorNoVetor() {
    final int[] vetor = {1, 3, 5, 7, 9};

    final int result = this.bs.rank(5, vetor);

    assertEquals(2, result);
  }

  @Test
  public void buscaUmValorNoVetorVazio() {
    final int[] vetor = new int[]{};

    final int result = this.bs.rank(1, vetor);

    assertEquals(-1, result);
  }

  @Test
  public void buscaUmValorInexistenteNoVetor() {
    final int[] vetor = {1, 3, 5, 7, 9};

    final int result = this.bs.rank(2, vetor);

    assertEquals(-1, result);
  }
}

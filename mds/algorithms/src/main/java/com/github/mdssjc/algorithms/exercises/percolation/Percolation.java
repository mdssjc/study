package com.github.mdssjc.algorithms.exercises.percolation;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

/**
 * Percolation Model.
 *
 * @author Marcelo dos Santos
 *
 */
public class Percolation {

  private enum Directions {
    CENTER, TOP, BOTTOM, LEFT, RIGHT
  }

  private final WeightedQuickUnionUF sites;
  private final int                  size;
  /*
   * 0 - Blocked Site
   * 1 - Empty Open Site
   * 2 - Full Open Site
   */
  private final byte[]               status;
  private final int                  virtualTop;
  private final int                  virtualBottom;

  // create N-by-N grid, with all sites blocked
  public Percolation(final int N) {
    if (N <= 0) {
      throw new IllegalArgumentException("Illegal Argument Exception (N <= 0)");
    }

    this.size = N;
    final int gridSize = N * N;

    this.sites = new WeightedQuickUnionUF(gridSize + 2);
    this.status = new byte[gridSize + 2];

    this.virtualTop = gridSize;
    this.status[this.virtualTop] = 2;

    this.virtualBottom = gridSize + 1;
    this.status[this.virtualBottom] = 1;
  }

  // convert from 2D to 1D
  private int xyTo1D(final Directions direction, int row, int column) {
    if (row < 1 || row > this.size || column < 1 || column > this.size) {
      throw new IndexOutOfBoundsException("Index Out of Bounds Exception");
    }

    switch (direction) {
      case CENTER:
        // NOPS
        row--;
        column--;
        break;
      case TOP:
        if (row == 1) {
          return this.virtualTop;
        }
        row--;
        row--;
        column--;
        break;
      case BOTTOM:
        if (row == this.size) {
          return this.virtualBottom;
        }
        column--;
        break;
      case LEFT:
        row--;
        if (column != 1) {
          column--;
        }
        column--;
        break;
      case RIGHT:
        if (column != this.size) {
          column++;
        }
        row--;
        column--;
        break;
    }

    return row * this.size + column;
  }

  // open site (row i, column j) if it is not already
  public void open(final int i, final int j) {
    final int center = xyTo1D(Directions.CENTER, i, j);

    if (this.status[center] > 0) {
      return;
    }

    final int top = xyTo1D(Directions.TOP, i, j);
    final int bottom = xyTo1D(Directions.BOTTOM, i, j);
    final int left = xyTo1D(Directions.LEFT, i, j);
    final int right = xyTo1D(Directions.RIGHT, i, j);

    if (this.status[top] > 0) {
      this.sites.union(center, top);
    }
    if (this.status[bottom] > 0) {
      this.sites.union(center, bottom);
    }
    if (this.status[left] > 0) {
      this.sites.union(center, left);
    }
    if (this.status[right] > 0) {
      this.sites.union(center, right);
    }

    this.status[center] = 1;
    if (this.status[top] == 2 || this.status[bottom] == 2
        || this.status[left] == 2 || this.status[right] == 2) {
      updateStatus(center);
    }
  }

  // update site status
  private void updateStatus(final int cursor) {
    if (this.status[cursor] != 1 || cursor == this.virtualTop
        || cursor == this.virtualBottom) {
      return;
    }
    this.status[cursor] = 2;

    final int i = cursor / this.size + 1;
    final int j = cursor % this.size + 1;

    final int top = xyTo1D(Directions.TOP, i, j);
    final int bottom = xyTo1D(Directions.BOTTOM, i, j);
    final int left = xyTo1D(Directions.LEFT, i, j);
    final int right = xyTo1D(Directions.RIGHT, i, j);

    updateStatus(top);
    updateStatus(bottom);
    updateStatus(left);
    updateStatus(right);
  }

  // is site (row i, column j) open?
  public boolean isOpen(final int i, final int j) {
    return this.status[xyTo1D(Directions.CENTER, i, j)] > 0;
  }

  // is site (row i, column j) full?
  public boolean isFull(final int i, final int j) {
    return this.status[xyTo1D(Directions.CENTER, i, j)] == 2;
  }

  // does the system percolate?
  public boolean percolates() {
    return this.sites.connected(this.virtualTop, this.virtualBottom);
  }

  // test client
  public static void main(final String[] args) {
    // final String[] initial = { "6" };
    // InteractivePercolationVisualizer.main(initial);
  }
}

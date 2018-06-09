package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.introcs.chapter3.section31.StockQuote;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.2.8 Stock account.
 * <p>
 * Compilation:  javac StockAccount.java
 * Execution:    java StockAccount < input.txt
 * Dependencies: In.java StdOut.java StockQuote.java
 * Data files:   http://www.cs.princeton.edu/introcs/32class/Turing.txt
 * <p>
 * % more Turing.txt
 * Turing, Alan
 * 10.24
 * 5
 * 100 ADBE
 * 25 GOOG
 * 97 IBM
 * 250 MSFT
 * 200 YHOO
 * <p>
 * % java StockAccount Turing.txt
 * Turing, Alan
 *                  Cash: $    10.24
 *  100  ADBE   $ 40.62   $  4062.00
 *   25  GOOG   $500.03   $ 12500.75
 *   97   IBM   $117.35   $ 11382.95
 *  250  MSFT   $ 29.71   $  7427.50
 *  200  YHOO   $ 23.80   $  4760.00
 *                 Total: $ 40143.44
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive(value = "Turing.txt", valueFile = true)
public class StockAccount {

  private final String name;
  private final double cash;
  private final int n;
  private final int[] shares;
  private final String[] stocks;

  public StockAccount(final String filename) {
    final var in = new In(filename);
    this.name = in.readLine();
    this.cash = in.readDouble();
    this.n = in.readInt();
    this.shares = new int[this.n];
    this.stocks = new String[this.n];
    for (var i = 0; i < this.n; i++) {
      this.shares[i] = in.readInt();
      this.stocks[i] = in.readString();
    }
  }

  public void printReport() {
    StdOut.println(this.name);
    var total = this.cash;
    for (var i = 0; i < this.n; i++) {
      final var amount = this.shares[i];
      final var price = StockQuote.priceOf(this.stocks[i]);
      total += amount * price;
      StdOut.printf("%4d %5s ", amount, this.stocks[i]);
      StdOut.printf("%9.2f %11.2f%n", price, amount * price);
    }
    StdOut.printf("%21s %10.2f%n", "Cash: ", this.cash);
    StdOut.printf("%21s %10.2f%n", "Total:", total);
  }

  public double valueOf() {
    StdOut.println(this.name);
    var total = this.cash;
    for (var i = 0; i < this.n; i++) {
      final var amount = this.shares[i];
      final var price = StockQuote.priceOf(this.stocks[i]);
      total += amount * price;
    }
    return total;
  }

  public static void main(final String[] args) {
    Executor.execute(StockAccount.class, args);

    final var filename = args[0];
    final var account = new StockAccount(filename);
    account.printReport();
  }
}

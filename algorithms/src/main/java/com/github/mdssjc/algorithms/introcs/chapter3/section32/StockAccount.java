package com.github.mdssjc.algorithms.introcs.chapter3.section32;

import com.github.mdssjc.algorithms.introcs.chapter3.section31.StockQuote;
import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.2.8 Stock account.
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
    final In in = new In(filename);
    this.name = in.readLine();
    this.cash = in.readDouble();
    this.n = in.readInt();
    this.shares = new int[this.n];
    this.stocks = new String[this.n];
    for (int i = 0; i < this.n; i++) {
      this.shares[i] = in.readInt();
      this.stocks[i] = in.readString();
    }
  }

  public void printReport() {
    StdOut.println(this.name);
    double total = this.cash;
    for (int i = 0; i < this.n; i++) {
      final int amount = this.shares[i];
      final double price = StockQuote.priceOf(this.stocks[i]);
      total += amount * price;
      StdOut.printf("%4d %5s ", amount, this.stocks[i]);
      StdOut.printf("%9.2f %11.2f%n", price, amount * price);
    }
    StdOut.printf("%21s %10.2f%n", "Cash: ", this.cash);
    StdOut.printf("%21s %10.2f%n", "Total:", total);
  }

  public static void main(final String[] args) {
    Executor.execute(StockAccount.class, args);

    final StockAccount account = new StockAccount(args[0]);
    account.printReport();
  }
}

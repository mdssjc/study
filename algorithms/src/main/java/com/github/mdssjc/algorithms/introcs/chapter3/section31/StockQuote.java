package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.1.8 Screen scraping for stock quotes.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("goog")
@TestDrive("adbe")
public class StockQuote {

  private static String readHTML(final String symbol) {
    final In page = new In("https://finance.yahoo.com/quote/" + symbol);
    return page.readAll();
  }

  public static double priceOf(final String symbol) {
    final String html = readHTML(symbol);
    final int p = html.indexOf("\"quoteData\":{\"" + symbol.toUpperCase(), 0);
    final int from = html.indexOf("raw", p);
    final int to = html.indexOf(",", from);
    final String price = html.substring(from + 5, to);
    return Double.parseDouble(price.replaceAll(",", ""));
  }

  public static void main(final String[] args) {
    Executor.execute(StockQuote.class, args);

    final String symbol = args[0];
    final double price = priceOf(symbol);
    StdOut.println(price);
  }
}

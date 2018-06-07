package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;
import com.github.mdssjc.algorithms.utils.TestDrive;
import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.StdOut;

/**
 * Program 3.1.8 Screen scraping for stock quotes.
 * <p>
 * Compilation:  javac StockQuote.java
 * Execution:    java StockQuote symbol
 * Dependencies: In.java, StdOut.java
 * <p>
 * Print the stock price of the stock with the given symbol.
 * Screen scrapes http://finance.yahoo.com to get the current price
 * and associated information.
 * <p>
 * Warning: if Yahoo updates the format of their page,
 * this program also needs to be updated.
 * <p>
 * % java StockQuote GOOG
 * 744.0
 * Alphabet Inc.
 * Wed Jul 27 12:19:16 PDT 2016
 * <p>
 * % java StockQuote AAPL
 * 103.78
 * Apple Inc.
 * Wed Jul 27 12:19:21 PDT 2016
 * <p>
 * % java StockQuote IBM
 * 162.29
 * International Business Machines Corporation
 * Wed Jul 27 12:19:26 PDT 2016
 * <p>
 * % java StockQuote MSFT
 * 56.46
 * Microsoft Corporation
 * Wed Jul 27 12:19:30 PDT 2016
 *
 * FIXME: corrigir o parse da paǵina.
 *
 * @author Marcelo dos Santos
 *
 */
@TestDrive("GOOG")
@TestDrive("AAPL")
@TestDrive("IBM")
@TestDrive("MSFT")
public class StockQuote {

  private static String readHTML(final String symbol) {
    final var page = new In("https://finance.yahoo.com/quote/" + symbol);
    final var html = page.readAll();
    if (html.contains("<title></title>")) {
      return null;
    } else {
      return html;
    }
  }

  public static double priceOf(final String symbol) {
    final var html = readHTML(symbol);
    final var p = html.indexOf("\"quoteData\":{\"" + symbol.toUpperCase(), 0);
    final var from = html.indexOf("raw", p);
    final var to = html.indexOf(",", from);
    final var price = html.substring(from + 5, to);

    return Double.parseDouble(price.replaceAll(",", ""));
  }

  public static double priceOf(final String symbol, final String html) {
    final var p = html.indexOf("price.0", 0);
    final var from = html.indexOf(">", p);
    final var to = html.indexOf("</span>", from);
    final var price = html.substring(from + 1, to);

    return Double.parseDouble(price.replaceAll(",", ""));
  }

  public static String nameOf(final String symbol, final String html) {
    final var p = html.indexOf("symbol.$companyName", 0);
    final var from = html.indexOf(">", p);
    final var to = html.indexOf("</h6>", from);
    final var name = html.substring(from + 1, to);
    return name;
  }

  public static String dateOf(final String symbol, final String html) {
    final var p = html.indexOf("adx.bf1.yahoo.com", 0);
    final var from = html.indexOf(" ", p);
    final var to = html.indexOf("-->", from);
    final var date = html.substring(from + 1, to);
    return date;
  }

  public static void main(final String[] args) {
    Executor.execute(StockQuote.class, args);

    final var symbol = args[0];
    final var html = readHTML(symbol);
    final var price = priceOf(symbol);
    StdOut.println(price);

    if (html == null) {
      StdOut.println("Invalid symbol: " + symbol);
    } else {
      StdOut.println(priceOf(symbol, html));
      StdOut.println(nameOf(symbol, html));
      StdOut.println(dateOf(symbol, html));
    }
  }
}

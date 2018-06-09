package com.github.mdssjc.algorithms.introcs.chapter3.section31;

import com.github.mdssjc.algorithms.utils.Executor;

/**
 * Simulator Class.
 *
 * @author Marcelo dos Santos
 *
 */
public class Simulator {

  public static void main(final String[] args) {
    Executor.execute(PotentialGene.class, "Program 3.1.1 Identifying a potential gene");
    Executor.execute(AlbersSquares.class, "Program 3.1.2 Albers squares");
    Executor.execute(Luminance.class, "Program 3.1.3 Luminance library");
    Executor.execute(Grayscale.class, "Program 3.1.4 Converting color to grayscale");
    Executor.execute(Scale.class, "Program 3.1.5 Image scaling");
    Executor.execute(Fade.class, "Program 3.1.6 Fade effect");
    Executor.execute(Cat.class, "Program 3.1.7 Concatenating files");
    Executor.execute(StockQuote.class, "Program 3.1.8 Screen scraping for stock quotes");
    Executor.execute(Split.class, "Program 3.1.9 Splitting a file");
  }
}

package com.github.mdssjc.dp.observer.base;

import com.github.mdssjc.dp.observer.concrete.CloseObserver;
import com.github.mdssjc.dp.observer.concrete.PrintObserver;
import com.github.mdssjc.dp.observer.subject.News;

/**
 * Test drive do padrão de projeto Observer.
 * <p>
 * Design Pattern
 * Behavioral - Observer (Dependents, Publish-Subscribe)
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  private static final int MILLIS = 50;

  public static void main(final String[] args) throws InterruptedException {
    final News news = new News();
    final CloseObserver run = new CloseObserver();

    news.addObserver(new PrintObserver());
    news.addObserver(run);
    news.run();

    while (run.isClose()) {
      Thread.sleep(MILLIS);
    }
  }
}

/*
 * Design Pattern
 * Behavioral - Observer (Dependents, Publish-Subscribe)
 * 
 */

package base;

import observer.CloseObserver;
import observer.PrintObserver;
import subject.News;

public class Main {
    private static final int MILLIS = 50;

    public static void main(String[] args) throws InterruptedException {
        News news = new News();
        CloseObserver run = new CloseObserver();

        news.addObserver(new PrintObserver());
        news.addObserver(run);
        news.run();

        while (run.isClose()) {
            Thread.sleep(MILLIS);
        }
    }
}

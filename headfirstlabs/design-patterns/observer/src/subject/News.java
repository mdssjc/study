package subject;

import java.util.Observable;
import java.util.Random;

public class News extends Observable implements Runnable {

    private static final int LIMIT       = 10;
    private static final int BOUND       = 10000;
    private static final int SLEEP_IN_5S = 5000;
    private int              i           = 0;

    @Override
    public void run() {
        while (i <= LIMIT) {
            try {
                i++;
                Thread.sleep(SLEEP_IN_5S);
                setChanged();
                // Pull
                // notifyObservers();
                // Push
                notifyObservers(new Random().nextInt(BOUND));
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        }
        setChanged();
        notifyObservers(false);
    }
}

package observer;

import java.util.Observable;
import java.util.Observer;

public class PrintObserver implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Integer) {
            System.out.println(arg);
        }
    }
}

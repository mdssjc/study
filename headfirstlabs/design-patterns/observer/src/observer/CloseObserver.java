package observer;

import java.util.Observable;
import java.util.Observer;

public class CloseObserver implements Observer {

    private boolean flag = true;

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Boolean) {
            flag = (boolean) arg;
        }
    }

    public boolean isClose() {
        return flag;
    }
}

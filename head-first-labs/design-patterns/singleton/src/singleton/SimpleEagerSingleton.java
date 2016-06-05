package singleton;

public class SimpleEagerSingleton {

    private static SimpleEagerSingleton instance = new SimpleEagerSingleton();

    private SimpleEagerSingleton() {
    }

    public static SimpleEagerSingleton getInstance() {
        return instance;
    }
}

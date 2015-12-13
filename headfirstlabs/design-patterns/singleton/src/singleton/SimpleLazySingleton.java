package singleton;

public class SimpleLazySingleton {

    public static SimpleLazySingleton instance;

    private SimpleLazySingleton() {
    }

    public static SimpleLazySingleton getInstance() {
        if (instance == null) {
            instance = new SimpleLazySingleton();
        }
        return instance;
    }
}

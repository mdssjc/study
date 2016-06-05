/*
 * Design Pattern
 * Creational - Singleton
 * 
 */
package base;

import singleton.DoubleCheckSingleton;
import singleton.SimpleEagerSingleton;
import singleton.SimpleLazySingleton;
import singleton.SynchronizedSingleton;

public class Main {

    public static void main(String[] args) {
        SimpleLazySingleton lazy = SimpleLazySingleton.getInstance();
        SimpleEagerSingleton eager = SimpleEagerSingleton.getInstance();
        SynchronizedSingleton sync = SynchronizedSingleton.getInstance();
        DoubleCheckSingleton doubleCheck = DoubleCheckSingleton.getInstance();

        System.out.println(lazy);
        System.out.println(eager);
        System.out.println(sync);
        System.out.println(doubleCheck);
    }
}

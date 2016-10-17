package com.github.mdssjc.dp.singleton.base;

import com.github.mdssjc.dp.singleton.DoubleCheckSingleton;
import com.github.mdssjc.dp.singleton.SimpleEagerSingleton;
import com.github.mdssjc.dp.singleton.SimpleLazySingleton;
import com.github.mdssjc.dp.singleton.SynchronizedSingleton;

/**
 * Test drive do padrão de projeto Singleton.
 * <p>
 * Design Pattern
 * Creational - Singleton
 * <p>
 * Pode ser substituído pelo Dependency Injection.
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final SimpleLazySingleton lazy = SimpleLazySingleton.getInstance();
    final SimpleEagerSingleton eager = SimpleEagerSingleton.getInstance();
    final SynchronizedSingleton sync = SynchronizedSingleton.getInstance();
    final DoubleCheckSingleton doubleCheck = DoubleCheckSingleton.getInstance();

    System.out.println(lazy);
    System.out.println(eager);
    System.out.println(sync);
    System.out.println(doubleCheck);
  }
}

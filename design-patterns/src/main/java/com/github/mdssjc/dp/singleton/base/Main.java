package com.github.mdssjc.dp.singleton.base;

import com.github.mdssjc.dp.singleton.*;

/**
 * Test drive do padrão de projeto Singleton.
 * <p>
 * Design Pattern
 * Creational - Singleton
 * <p>
 * Pode ser substituído pelo Dependency Injection.
 * DoubleCheckSingleton é um anti-pattern.
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
    final EnumSingleton enumerated = EnumSingleton.INSTANCE;
    final InitializeOnDemandSingleton ondemand = InitializeOnDemandSingleton.getInstance();

    System.out.println(lazy);
    System.out.println(eager);
    System.out.println(sync);
    System.out.println(doubleCheck);
    System.out.println(enumerated);
    System.out.println(ondemand);
  }
}

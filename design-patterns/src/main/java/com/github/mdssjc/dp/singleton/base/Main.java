package com.github.mdssjc.dp.singleton.base;

import com.github.mdssjc.dp.singleton.singleton.DoubleCheckSingleton;
import com.github.mdssjc.dp.singleton.singleton.SimpleEagerSingleton;
import com.github.mdssjc.dp.singleton.singleton.SimpleLazySingleton;
import com.github.mdssjc.dp.singleton.singleton.SynchronizedSingleton;

/**
 * Test drive do padrão de projeto Singleton.
 * </p>
 * Design Pattern
 * Creational - Singleton
 * </p>
 * Pode ser substituído pelo Dependency Injection.
 *
 * @author mdssjc &lt;Marcelo dos Santos&gt;
 *
 */
public class Main {

  /**
   * Ponto de entrada para a execução experimental do Singleton.
   *
   * @param args
   *          Não utilizado
   */
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

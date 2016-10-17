package com.github.mdssjc.dp.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementação do padrão Singleton.
 * <p>
 * Algoritmo: 'Synchronized'
 *
 * @author Marcelo dos Santos
 *
 */
@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class SynchronizedSingleton {

  private static SynchronizedSingleton uniqueInstance;
  @Getter
  private int singletonData;

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Synchronized Singleton";
  }

  public static synchronized SynchronizedSingleton getInstance() {
    if (SynchronizedSingleton.uniqueInstance == null) {
      SynchronizedSingleton.uniqueInstance = new SynchronizedSingleton();
    }
    return SynchronizedSingleton.uniqueInstance;
  }
}

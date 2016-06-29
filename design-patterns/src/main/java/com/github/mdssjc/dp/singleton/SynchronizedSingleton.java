package com.github.mdssjc.dp.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementação do padrão Singleton.
 * Algoritmo: 'Synchronized'
 *
 * @author mdssjc &lt;Marcelo dos Santos&gt;
 * 
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SynchronizedSingleton {

  private static SynchronizedSingleton uniqueInstance;
  @Getter
  private int                          singletonData;

  /**
   * Obtém a instância do objeto.
   *
   * @return instância do objeto
   */
  public static synchronized SynchronizedSingleton getInstance() {
    if (SynchronizedSingleton.uniqueInstance == null) {
      SynchronizedSingleton.uniqueInstance = new SynchronizedSingleton();
    }
    return SynchronizedSingleton.uniqueInstance;
  }

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Synchronized Singleton";
  }
}

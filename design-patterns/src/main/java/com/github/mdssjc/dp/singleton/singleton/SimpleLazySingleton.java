package com.github.mdssjc.dp.singleton.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementação do padrão Singleton.
 * Algoritmo: 'Lazy'
 *
 * @author mdssjc &lt;Marcelo dos Santos&gt;
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleLazySingleton {

  private static SimpleLazySingleton uniqueInstance;
  @Getter
  private int                        singletonData;

  /**
   * Obtém a instância do objeto.
   *
   * @return instância do objeto
   */
  public static SimpleLazySingleton getInstance() {
    if (SimpleLazySingleton.uniqueInstance == null) {
      SimpleLazySingleton.uniqueInstance = new SimpleLazySingleton();
    }
    return SimpleLazySingleton.uniqueInstance;
  }

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Simple Lazy Singleton";
  }
}

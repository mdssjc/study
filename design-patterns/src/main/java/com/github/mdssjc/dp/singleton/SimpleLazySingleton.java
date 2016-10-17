package com.github.mdssjc.dp.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementação do padrão Singleton.
 * <p>
 * Algoritmo: 'Lazy'
 *
 * @author Marcelo dos Santos
 *
 */
@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class SimpleLazySingleton {

  private static SimpleLazySingleton uniqueInstance;
  @Getter
  private int singletonData;

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Simple Lazy Singleton";
  }

  public static SimpleLazySingleton getInstance() {
    if (SimpleLazySingleton.uniqueInstance == null) {
      SimpleLazySingleton.uniqueInstance = new SimpleLazySingleton();
    }
    return SimpleLazySingleton.uniqueInstance;
  }
}

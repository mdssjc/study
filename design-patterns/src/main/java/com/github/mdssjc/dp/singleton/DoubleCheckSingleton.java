package com.github.mdssjc.dp.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementação do padrão Singleton.
 * <p>
 * Algoritmo: 'Double Check'
 *
 * @author Marcelo dos Santos
 *
 */
@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class DoubleCheckSingleton {

  private static volatile DoubleCheckSingleton uniqueInstance;
  @Getter
  private int singletonData;

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Double Check Singleton";
  }

  public static DoubleCheckSingleton getInstance() {
    if (DoubleCheckSingleton.uniqueInstance == null) {
      synchronized (DoubleCheckSingleton.class) {
        if (DoubleCheckSingleton.uniqueInstance == null) {
          DoubleCheckSingleton.uniqueInstance = new DoubleCheckSingleton();
        }
      }
    }
    return DoubleCheckSingleton.uniqueInstance;
  }
}

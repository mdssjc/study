package com.github.mdssjc.dp.singleton.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementação do padrão Singleton.
 * Algoritmo: 'Double Check'
 *
 * @author mdssjc &lt;Marcelo dos Santos&gt;
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class DoubleCheckSingleton {

  private static volatile DoubleCheckSingleton uniqueInstance;
  @Getter
  private int                                  singletonData;

  /**
   * Obtém a instância do objeto.
   *
   * @return instância do objeto
   */
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

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Double Check Singleton";
  }
}

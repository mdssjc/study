package com.github.mdssjc.dp.singleton.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementação do padrão Singleton.
 * Algoritmo: 'Eager'
 *
 * @author mdssjc &lt;Marcelo dos Santos&gt;
 *
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SimpleEagerSingleton {

  private static SimpleEagerSingleton uniqueInstance = new SimpleEagerSingleton();
  @Getter
  private int                         singletonData;

  /**
   * Obtém a instância do objeto.
   *
   * @return instância do objeto
   */
  public static SimpleEagerSingleton getInstance() {
    return SimpleEagerSingleton.uniqueInstance;
  }

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Simple Eager Singleton";
  }
}

package com.github.mdssjc.dp.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementação do padrão Singleton.
 * <p>
 * Algoritmo: 'Eager'
 *
 * @author Marcelo dos Santos
 *
 */
@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class SimpleEagerSingleton {

  private static final SimpleEagerSingleton uniqueInstance = new SimpleEagerSingleton();
  @Getter
  private int singletonData;

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Simple Eager Singleton";
  }

  public static SimpleEagerSingleton getInstance() {
    return SimpleEagerSingleton.uniqueInstance;
  }
}

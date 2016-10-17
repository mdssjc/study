package com.github.mdssjc.dp.singleton;

/**
 * Implementação do padrão Singleton.
 * <p>
 * Algoritmo: 'Enum'
 *
 * @author Marcelo dos Santos
 *
 */
public enum EnumSingleton {
  INSTANCE;

  private int singletonData;

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Enum Singleton";
  }
}

package com.github.mdssjc.dp.singleton;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Implementação do padrão Singleton.
 * <p>
 * Algoritmo: 'Initialize-on-demand'
 *
 * @author Marcelo dos Santos
 *
 */
@NoArgsConstructor( access = AccessLevel.PRIVATE )
public class InitializeOnDemandSingleton {

  @Getter
  private int singletonData;

  public void singletonOperation() {
    this.singletonData++;
  }

  @Override
  public String toString() {
    return "Initialize-on-demand Singleton";
  }

  private static class ResourceHolder {

    private static final InitializeOnDemandSingleton uniqueInstance = new InitializeOnDemandSingleton();
  }

  public static InitializeOnDemandSingleton getInstance() {
    return ResourceHolder.uniqueInstance;
  }
}

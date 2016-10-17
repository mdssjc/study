package com.github.mdssjc.dp.strategy.contexts;

import com.github.mdssjc.dp.strategy.algorithms.Algorithm;
import com.github.mdssjc.dp.strategy.algorithms.concrete.NullAlgorithm;

/**
 * Classe Abstrata Implementation X.
 *
 * @author Marcelo dos Santos
 *
 */
public abstract class ImplementationX {

  private Algorithm algorithm;

  public ImplementationX() {
    // Null Object Pattern
    this.algorithm = new NullAlgorithm();
  }

  public void setAlgorithm(Algorithm algorithm) {
    this.algorithm = algorithm;
  }

  public void useAlgorithm() {
    algorithm.execute();
  }
}

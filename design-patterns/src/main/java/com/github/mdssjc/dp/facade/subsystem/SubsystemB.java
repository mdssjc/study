package com.github.mdssjc.dp.facade.subsystem;

import java.util.Random;

/**
 * Implementação do Subsystem B.
 *
 * @author Marcelo dos Santos
 *
 */
public class SubsystemB {

  private double result;

  public void doCalc() {
    this.result = new Random().nextInt(1000) / Math.PI;
  }

  public double getResult() {
    return this.result;
  }
}

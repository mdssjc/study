package com.github.mdssjc.design_patterns.structural.facade;

import java.util.Random;

/**
 * Subsystem Classes.
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

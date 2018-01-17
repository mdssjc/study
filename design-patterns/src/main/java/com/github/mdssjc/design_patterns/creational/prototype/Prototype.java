package com.github.mdssjc.design_patterns.creational.prototype;

/**
 * Prototype.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Prototype extends Cloneable {

  Prototype clone();

  String message();
}

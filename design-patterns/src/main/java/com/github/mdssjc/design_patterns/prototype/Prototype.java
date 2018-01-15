package com.github.mdssjc.design_patterns.prototype;

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

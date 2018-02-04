package com.github.mdssjc.design_patterns.behavioral.mediator;

/**
 * Mediator.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Mediator {

  String message();

  void colleagueChanged(Colleague colleague);

  void createColleagues();
}

package com.github.mdssjc.design_patterns.behavioral.mediator;

/**
 * Concrete Colleague 1.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteColleague1 extends Colleague {

  public ConcreteColleague1(final Mediator mediator) {
    super(mediator);
  }

  @Override
  public String message() {
    changed();
    return "Concrete Colleague 1" + ((getValue() == 0)
                                     ? ""
                                     : " " + getValue());
  }
}

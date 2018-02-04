package com.github.mdssjc.design_patterns.behavioral.mediator;

/**
 * Concrete Colleague 2.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteColleague2 extends Colleague {

  public ConcreteColleague2(final Mediator mediator) {
    super(mediator);
  }

  @Override
  public String message() {
    changed();
    return "Concrete Colleague 2" + ((getValue() == 0)
                                     ? ""
                                     : " " + (char) (getValue() + 32));
  }
}

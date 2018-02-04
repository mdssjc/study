package com.github.mdssjc.design_patterns.behavioral.mediator;

/**
 * Concrete Mediator.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteMediator implements Mediator {

  private Colleague colleague1;
  private Colleague colleague2;
  private int index;
  private int count;

  @Override
  public String message() {
    return (this.index == 0)
           ? this.colleague1.message()
           : this.colleague2.message();
  }

  @Override
  public void colleagueChanged(final Colleague colleague) {
    this.index = (this.index == 0) ? 1 : 0;
    colleague.setValue(this.count++);
  }

  @Override
  public void createColleagues() {
    this.colleague1 = new ConcreteColleague1(this);
    this.colleague2 = new ConcreteColleague2(this);
  }
}

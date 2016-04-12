package iloveyouboss.controller;

import java.time.Clock;

public class QuestionController {

  private Clock clock = Clock.systemUTC();

  public int addBooleanQuestion(final String text) {
    return persist(new BooleanQuestion(text));
  }

  void setClock(final Clock clock) {
    this.clock = clock;
  }

  private int persist(final Persistable object) {
    object.setCreateTimestamp(this.clock.instant());
    executeInTransaction((em) -> em.persist(object));
    return object.getId();
  }
}

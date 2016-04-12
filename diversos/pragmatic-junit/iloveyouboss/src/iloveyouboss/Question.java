package iloveyouboss;

import java.time.Instant;

import iloveyouboss.domain.Persistable;

public abstract class Question implements Persistable {

  private final String   text;
  private final String[] answerChoices;
  private int            id;

  public Question(final int id, final String text,
      final String[] answerChoices) {
    this.id = id;
    this.text = text;
    this.answerChoices = answerChoices;
  }

  @Override
  public Integer getId() {
    return this.id;
  }

  @Override
  public void setId(final Integer id) {
    this.id = id;
  }

  @Override
  public Instant getCreateTimestamp() {
    return null;
  }

  @Override
  public void setCreateTimestamp(final Instant instant) {
  }

  public String getText() {
    return this.text;
  }

  public String getAnswerChoice(final int i) {
    return this.answerChoices[i];
  }

  public boolean match(final Answer answer) {
    return false;
  }

  public abstract boolean match(int expected, int actual);

  public int indexOf(final String matchingAnswerChoice) {
    for (int i = 0; i < this.answerChoices.length; i++) {
      if (this.answerChoices[i].equals(matchingAnswerChoice)) {
        return i;
      }
    }
    return -1;
  }
}

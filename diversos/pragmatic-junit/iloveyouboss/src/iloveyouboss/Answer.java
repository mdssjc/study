package iloveyouboss;

public class Answer {

  private final int      i;
  private final Question question;

  public Answer(final Question question, final int i) {
    this.question = question;
    this.i = i;
  }

  public Answer(final Question question, final String matchingValue) {
    this.question = question;
    this.i = question.indexOf(matchingValue);
  }

  public String getQuestionText() {
    return this.question.getText();
  }

  @Override
  public String toString() {
    return String.format("%s %s", this.question.getText(),
        this.question.getAnswerChoice(this.i));
  }

  public boolean match(final int expected) {
    return this.question.match(expected, this.i);
  }

  public boolean match(final Answer otherAnswer) {
    if (otherAnswer == null) {
      return false;
    }
    return this.question.match(this.i, otherAnswer.i);
  }

  public Question getQuestion() {
    return this.question;
  }
}

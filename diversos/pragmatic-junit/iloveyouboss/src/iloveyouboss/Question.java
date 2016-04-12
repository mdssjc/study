package iloveyouboss;

public abstract class Question {

  private final String   text;
  private final String[] answerChoices;
  private final int      id;

  public Question(final int id, final String text,
      final String[] answerChoices) {
    this.id = id;
    this.text = text;
    this.answerChoices = answerChoices;
  }

  public int getId() {
    return this.id;
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

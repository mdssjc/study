package iloveyouboss;

public class PercentileQuestion extends Question {

  public PercentileQuestion(final int id, final String text,
      final String[] answerChoices) {
    super(id, text, answerChoices);
  }

  @Override
  public boolean match(final int expected, final int actual) {
    return expected <= actual;
  }
}

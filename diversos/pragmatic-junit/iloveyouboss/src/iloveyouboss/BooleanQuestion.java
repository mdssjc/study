package iloveyouboss;

public class BooleanQuestion extends Question {

  public BooleanQuestion(final int id, final String text) {
    super(id, text, new String[] { "No", "Yes" });
  }

  @Override
  public boolean match(final int expected, final int actual) {
    return expected == actual;
  }
}

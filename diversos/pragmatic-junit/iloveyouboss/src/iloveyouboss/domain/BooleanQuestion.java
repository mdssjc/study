package iloveyouboss.domain;

import java.util.Arrays;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "boolean")
public class BooleanQuestion extends Question {

  private static final long serialVersionUID = 1L;

  public BooleanQuestion() {
  }

  public BooleanQuestion(final String text) {
    super(text);
  }

  public BooleanQuestion(final int id, final String text) {
    this(text);
    setId(id);
  }

  @Override
  public List<String> getAnswerChoices() {
    return Arrays.asList(new String[] { "No", "Yes" });
  }

  @Override
  public boolean match(final int expected, final int actual) {
    return expected == actual;
  }
}

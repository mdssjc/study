package iloveyouboss;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class AnswerTest {

  @Test
  public void matchAgainstNullAnswerReturnsFalse() {
    assertFalse(new Answer(new BooleanQuestion(0, ""), Bool.TRUE).match(null));
  }
}

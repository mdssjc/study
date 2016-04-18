package iloveyouboss;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import iloveyouboss.domain.BooleanQuestion;

public class AnswerTest {

  @Test
  public void matchAgainstNullAnswerReturnsFalse() {
    assertFalse(new Answer(new BooleanQuestion(""), Bool.TRUE).match(null));
  }
}

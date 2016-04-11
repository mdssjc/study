package iloveyouboss;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ProfileTest {

  @Test
  public void matches() {
    private final Profile profile = new Profile("Bull Hockey, Inc.");
    private final BooleanQuestion question = new BooleanQuestion(1,
        "Got bonuses?");

    // answers false when must-match criteria not met
    this.profile.add(new Answer(this.question, Bool.FALSE));
    private final Criteria criteria = new Criteria();
    this.criteria.add(new Criterion(
        new Answer(this.question, Bool.TRUE),
        Weight.MustMatch));

    assertFalse(this.profile.matches(this.criteria));

    // answers true for any don't care criteria
    this.profile.add(new Answer(this.question, Bool.FALSE));
    this.criteria.add(new Criterion(
        new Answer(this.question, Bool.TRUE),
        Weight.DontCare));

    assertTrue(this.profile.matches(this.criteria));
  }
}

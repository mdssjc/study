package iloveyouboss;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ProfileTest {

  private Profile         profile;
  private BooleanQuestion question;
  private Criteria        criteria;

  @Before
  public void create() {
    this.profile = new Profile("Bull Hockey, Inc.");
    this.question = new BooleanQuestion(1, "Got bonuses?");
    this.criteria = new Criteria();
  }

  @Test
  public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
    this.profile.add(new Answer(this.question, Bool.FALSE));
    final Criterion criterion = new Criterion(
        new Answer(this.question, Bool.TRUE),
        Weight.MustMatch);
    this.criteria.add(criterion);

    final boolean matches = this.profile.matches(this.criteria);

    assertFalse(matches);
  }

  @Test
  public void matchAnswersTrueForAnyDontCareCriteria() {
    this.profile.add(new Answer(this.question, Bool.FALSE));
    final Criterion criterion = new Criterion(
        new Answer(this.question, Bool.TRUE),
        Weight.DontCare);
    this.criteria.add(criterion);

    final boolean matches = this.profile.matches(this.criteria);

    assertTrue(matches);
  }
}

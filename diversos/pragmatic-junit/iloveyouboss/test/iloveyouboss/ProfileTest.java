package iloveyouboss;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class ProfileTest {

  private Profile         profile;
  private BooleanQuestion questionIsThereRelocation;
  private Answer          answerThereIsRelocation;
  private Answer          answerThereIsNotRelocation;
  private BooleanQuestion questionReimbursesTuition;
  private Answer          answerReimbursesTuition;
  private Answer          answerDoesNotReimbursesTuition;
  private Criteria        criteria;

  @Before
  public void createProfile() {
    this.profile = new Profile();
  }

  @Before
  public void createQuestionAndAnswer() {
    this.questionIsThereRelocation = new BooleanQuestion(1,
        "Relocation package?");
    this.answerThereIsRelocation = new Answer(this.questionIsThereRelocation,
        Bool.TRUE);
    this.answerThereIsNotRelocation = new Answer(this.questionIsThereRelocation,
        Bool.FALSE);

    this.questionReimbursesTuition = new BooleanQuestion(1,
        "Reimburses tuition?");
    this.answerReimbursesTuition = new Answer(this.questionReimbursesTuition,
        Bool.TRUE);
    this.answerDoesNotReimbursesTuition = new Answer(
        this.questionReimbursesTuition,
        Bool.FALSE);
  }

  @Before
  public void createCriteria() {
    this.criteria = new Criteria();
  }

  @Test
  public void matchesCriterionWhenMatchesSoleAnswer() {
    this.profile.add(this.answerThereIsRelocation);
    final Criterion criterion = new Criterion(this.answerThereIsRelocation,
        Weight.Important);

    assertTrue(this.profile.matches(criterion));
  }

  @Test
  public void doesNotMatchCriterionWhenNoMatchingAnswerContained() {
    this.profile.add(this.answerThereIsNotRelocation);
    final Criterion criterion = new Criterion(this.answerThereIsRelocation,
        Weight.Important);

    assertFalse(this.profile.matches(criterion));
  }

  @Test
  public void matchesCriterionWhenOneOfMultipleAnswerMatches() {
    this.profile.add(this.answerThereIsRelocation);
    this.profile.add(this.answerDoesNotReimbursesTuition);
    final Criterion criterion = new Criterion(this.answerThereIsRelocation,
        Weight.Important);

    assertTrue(this.profile.matches(criterion));
  }

  @Test
  public void doesNotMatchCriteriaWhenNoneOfMultipleCriteriaMatch() {
    this.profile.add(this.answerDoesNotReimbursesTuition);
    this.criteria = new Criteria();
    this.criteria.add(
        new Criterion(this.answerThereIsRelocation, Weight.Important));
    this.criteria.add(
        new Criterion(this.answerReimbursesTuition, Weight.Important));

    assertFalse(this.profile.matches(this.criteria));
  }

  @Test
  public void matchesCriteriaWhenAnyOfMultipleCriteriaMatch() {
    this.profile.add(this.answerThereIsRelocation);
    this.criteria = new Criteria();
    this.criteria.add(
        new Criterion(this.answerThereIsRelocation, Weight.Important));
    this.criteria.add(
        new Criterion(this.answerReimbursesTuition, Weight.Important));

    assertTrue(this.profile.matches(this.criteria));
  }

  @Test
  public void doesNotMatchWhenAnyMustMeetCriteriaNotMet() {
    this.profile.add(this.answerThereIsRelocation);
    this.profile.add(this.answerDoesNotReimbursesTuition);
    this.criteria.add(
        new Criterion(this.answerThereIsRelocation, Weight.Important));
    this.criteria.add(
        new Criterion(this.answerReimbursesTuition, Weight.MustMatch));

    assertFalse(this.profile.matches(this.criteria));
  }

  @Test
  public void alwaysMatchesDontCareCriterion() {
    this.profile.add(this.answerDoesNotReimbursesTuition);
    final Criterion criterion = new Criterion(this.answerReimbursesTuition,
        Weight.DontCare);

    assertTrue(this.profile.matches(criterion));
  }

  @Test
  public void scoreIsZeroWhenThereAreNoMatches() {
    this.criteria.add(
        new Criterion(this.answerThereIsRelocation, Weight.Important));

    final ProfileMatch match = this.profile.match(this.criteria);

    assertThat(match.getScore(), equalTo(0));
  }
}

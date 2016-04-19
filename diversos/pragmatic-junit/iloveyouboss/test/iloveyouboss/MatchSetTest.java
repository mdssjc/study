package iloveyouboss;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import iloveyouboss.domain.BooleanQuestion;
import iloveyouboss.domain.Question;

public class MatchSetTest {

  private Criteria         criteria;
  private Question         questionReimbursesTuition;

  private Answer           answerReimbursesTuition;
  private Answer           answerDoesNotReimburseTuition;

  private Question         questionIsThereRelocation;
  private Answer           answerThereIsRelocation;
  private Answer           answerThereIsNoRelocation;

  private Question         questionOnsiteDaycare;
  private Answer           answerNoOnsiteDaycare;
  private Answer           answerHasOnsiteDaycare;

  private AnswerCollection answers;

  @Before
  public void createAnswers() {
    this.answers = new AnswerCollection();
  }

  @Before
  public void createCriteria() {
    this.criteria = new Criteria();
  }

  @Before
  public void createQuestionsAndAnswers() {
    this.questionIsThereRelocation = new BooleanQuestion(1, "Relocation package?");
    this.answerThereIsRelocation = new Answer(this.questionIsThereRelocation,
        Bool.TRUE);
    this.answerThereIsNoRelocation = new Answer(this.questionIsThereRelocation,
        Bool.FALSE);

    this.questionReimbursesTuition = new BooleanQuestion(2, "Reimburses tuition?");
    this.answerReimbursesTuition = new Answer(this.questionReimbursesTuition,
        Bool.TRUE);
    this.answerDoesNotReimburseTuition = new Answer(
        this.questionReimbursesTuition,
        Bool.FALSE);

    this.questionOnsiteDaycare = new BooleanQuestion(3, "Onsite daycare?");
    this.answerHasOnsiteDaycare = new Answer(this.questionOnsiteDaycare,
        Bool.TRUE);
    this.answerNoOnsiteDaycare = new Answer(this.questionOnsiteDaycare,
        Bool.FALSE);
  }

  private MatchSet createMatchSet() {
    return new MatchSet(this.answers, this.criteria);
  }

  @Test
  public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
    this.answers.add(this.answerDoesNotReimburseTuition);
    this.criteria.add(
        new Criterion(this.answerReimbursesTuition, Weight.MustMatch));

    assertFalse(createMatchSet().matches());
  }

  @Test
  public void matchAnswersTrueForAnyDontCareCriteria() {
    this.answers.add(this.answerDoesNotReimburseTuition);
    this.criteria.add(
        new Criterion(this.answerReimbursesTuition, Weight.DontCare));

    assertTrue(createMatchSet().matches());
  }

  @Test
  public void matchAnswersTrueWhenAnyOfMultipleCriteriaMatch() {
    this.answers.add(this.answerThereIsRelocation);
    this.answers.add(this.answerDoesNotReimburseTuition);
    this.criteria.add(
        new Criterion(this.answerThereIsRelocation, Weight.Important));
    this.criteria.add(
        new Criterion(this.answerReimbursesTuition, Weight.Important));

    assertTrue(createMatchSet().matches());
  }

  @Test
  public void matchAnswersFalseWhenNoneOfMultipleCriteriaMatch() {
    this.answers.add(this.answerThereIsNoRelocation);
    this.answers.add(this.answerDoesNotReimburseTuition);
    this.criteria.add(
        new Criterion(this.answerThereIsRelocation, Weight.Important));
    this.criteria.add(
        new Criterion(this.answerReimbursesTuition, Weight.Important));

    assertFalse(createMatchSet().matches());
  }

  @Test
  public void scoreIsZeroWhenThereAreNoMatches() {
    this.answers.add(this.answerThereIsNoRelocation);
    this.criteria.add(
        new Criterion(this.answerThereIsRelocation, Weight.Important));

    assertThat(createMatchSet().getScore(), equalTo(0));
  }

  @Test
  public void scoreIsCriterionValueForSingleMatch() {
    this.answers.add(this.answerThereIsRelocation);
    this.criteria.add(
        new Criterion(this.answerThereIsRelocation, Weight.Important));

    assertThat(createMatchSet().getScore(),
        equalTo(Weight.Important.getValue()));
  }

  @Test
  public void scoreAccumulatesCriterionValuesForMatches() {
    this.answers.add(this.answerThereIsRelocation);
    this.answers.add(this.answerReimbursesTuition);
    this.answers.add(this.answerNoOnsiteDaycare);
    this.criteria.add(
        new Criterion(this.answerThereIsRelocation, Weight.Important));
    this.criteria.add(
        new Criterion(this.answerReimbursesTuition, Weight.WouldPrefer));
    this.criteria.add(
        new Criterion(this.answerHasOnsiteDaycare, Weight.VeryImportant));

    final int expectedScore = Weight.Important.getValue()
        + Weight.WouldPrefer.getValue();
    assertThat(createMatchSet().getScore(), equalTo(expectedScore));
  }
}

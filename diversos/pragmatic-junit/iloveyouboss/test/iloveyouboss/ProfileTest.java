package iloveyouboss;

import java.util.Collection;

import org.junit.Before;

public class ProfileTest {

  private Profile  profile;
  private Criteria criteria;

  private Question questionReimbursesTuition;
  private Answer   answerReimbursesTuition;
  private Answer   answerDoesNotReimburseTuition;

  private Question questionIsThereRelocation;
  private Answer   answerThereIsRelocation;
  private Answer   answerThereIsNoRelocation;

  private Question questionOnsiteDaycare;
  private Answer   answerNoOnsiteDaycare;
  private Answer   answerHasOnsiteDaycare;

  int[] ids(final Collection<Answer> answers) {
    return answers.stream()
                  .mapToInt(a -> a.getQuestion()
                                  .getId())
                  .toArray();
  }

  @Before
  public void createProfile() {
    this.profile = new Profile("Bull Hockey, Inc.");
  }

  @Before
  public void createCriteria() {
    this.criteria = new Criteria();
  }

  @Before
  public void createQuestionsAndAnswers() {
    this.questionIsThereRelocation = new BooleanQuestion(1,
        "Relocation package?");
    this.answerThereIsRelocation = new Answer(this.questionIsThereRelocation,
        Bool.TRUE);
    this.answerThereIsNoRelocation = new Answer(this.questionIsThereRelocation,
        Bool.FALSE);

    this.questionReimbursesTuition = new BooleanQuestion(1,
        "Reimburses tuition?");
    this.answerReimbursesTuition = new Answer(this.questionReimbursesTuition,
        Bool.TRUE);
    this.answerDoesNotReimburseTuition = new Answer(
        this.questionReimbursesTuition,
        Bool.FALSE);

    this.questionOnsiteDaycare = new BooleanQuestion(1, "Onsite daycare?");
    this.answerHasOnsiteDaycare = new Answer(this.questionOnsiteDaycare,
        Bool.TRUE);
    this.answerNoOnsiteDaycare = new Answer(this.questionOnsiteDaycare,
        Bool.FALSE);
  }
}

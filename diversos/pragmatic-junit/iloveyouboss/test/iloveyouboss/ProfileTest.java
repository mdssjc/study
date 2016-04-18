package iloveyouboss;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import iloveyouboss.domain.BooleanQuestion;
import iloveyouboss.domain.PercentileQuestion;

public class ProfileTest {

  private Profile profile;

  @Before
  public void createProfile() {
    this.profile = new Profile("");
  }

  int[] ids(final Collection<Answer> answers) {
    return answers.stream()
                  .mapToInt(a -> a.getQuestion()
                                  .getId())
                  .toArray();
  }

  @Test
  public void findsAnswersBasedOnPredicate() {
    this.profile.add(new Answer(new BooleanQuestion("1"), Bool.FALSE));
    this.profile.add(
        new Answer(new PercentileQuestion("2", new String[] {}), 0));
    this.profile.add(
        new Answer(new PercentileQuestion("3", new String[] {}), 0));

    final List<Answer> answers = this.profile.find(a -> a.getQuestion()
                                                         .getClass() == PercentileQuestion.class);

    assertThat(ids(answers), equalTo(new int[] { 2, 3 }));
  }
}

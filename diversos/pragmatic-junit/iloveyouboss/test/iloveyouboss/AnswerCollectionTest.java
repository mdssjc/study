package iloveyouboss;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import iloveyouboss.domain.BooleanQuestion;
import iloveyouboss.domain.PercentileQuestion;

public class AnswerCollectionTest {

  private AnswerCollection answers;

  @Before
  public void createProfile() {
    this.answers = new AnswerCollection();
  }

  int[] ids(final Collection<Answer> answers) {
    return answers.stream()
                  .mapToInt(a -> a.getQuestion()
                                  .getId())
                  .toArray();
  }

  @Test
  public void findsAnswersBasedOnPredicate() {
    this.answers.add(new Answer(new BooleanQuestion("1"), Bool.FALSE));
    this.answers.add(
        new Answer(new PercentileQuestion(2, "2", new String[] {}), 0));
    this.answers.add(
        new Answer(new PercentileQuestion(3, "3", new String[] {}), 0));

    final List<Answer> result = this.answers.find(a -> a.getQuestion()
                                                        .getClass() == PercentileQuestion.class);

    assertThat(ids(result), equalTo(new int[] { 2, 3 }));
  }
}

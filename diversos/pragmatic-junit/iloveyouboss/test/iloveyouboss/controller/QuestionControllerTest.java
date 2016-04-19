package iloveyouboss.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import iloveyouboss.domain.Question;

public class QuestionControllerTest {

  private QuestionController controller;

  @Before
  public void create() {
    this.controller = new QuestionController();
    this.controller.deleteAll();
  }

  @After
  public void cleanup() {
    this.controller.deleteAll();
  }

  @Test
  public void findsPersistedQuestionById() {
    final int id = this.controller.addBooleanQuestion("question text");

    final Question question = this.controller.find(id);

    assertThat(question.getText(), equalTo("question text"));
  }

  @Test
  public void questionAnswersDateAdded() {
    final Instant now = new Date().toInstant();
    this.controller.setClock(Clock.fixed(now, ZoneId.of("America/Denver")));
    final int id = this.controller.addBooleanQuestion("text");

    final Question question = this.controller.find(id);

    assertThat(question.getCreateTimestamp(), equalTo(now));
  }

  @Test
  public void answersMultiplePersistedQuestions() {
    this.controller.addBooleanQuestion("q1");
    this.controller.addBooleanQuestion("q2");
    this.controller.addPercentileQuestion("q3", new String[] { "a1", "a2" });

    final List<Question> questions = this.controller.getAll();

    assertThat(questions.stream()
                        .map(Question::getText)
                        .collect(Collectors.toList()),
        equalTo(Arrays.asList("q1", "q2", "q3")));
  }

  @Test
  public void findsMatchingEntries() {
    this.controller.addBooleanQuestion("alpha 1");
    this.controller.addBooleanQuestion("alpha 2");
    this.controller.addBooleanQuestion("beta 1");

    final List<Question> questions = this.controller.findWithMatchingText(
        "alpha");

    assertThat(questions.stream()
                        .map(Question::getText)
                        .collect(Collectors.toList()),
        equalTo(Arrays.asList("alpha 1", "alpha 2")));
  }
}

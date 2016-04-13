package iloveyouboss.controller;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import iloveyouboss.Question;

public class QuestionControllerTest {

  private QuestionController controller;

  @Before
  public void createController() {
    this.controller = new QuestionController();
  }

  @Test
  @Ignore("Missing database")
  public void questionAnswersDateAdded() {
    final Instant now = new Date().toInstant();
    this.controller.setClock(Clock.fixed(now, ZoneId.of("America/Denver")));
    final int id = this.controller.addBooleanQuestion("text");

    final Question question = this.controller.find(id);

    assertThat(question.getCreateTimestamp(), equalTo(now));
  }
}

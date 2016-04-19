package iloveyouboss.domain;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import iloveyouboss.controller.QuestionController;

public class StatCompilerTest {

  @Mock
  private QuestionController controller;
  @InjectMocks
  private StatCompiler       stats;

  @Before
  public void initialize() {
    this.stats = new StatCompiler();
    MockitoAnnotations.initMocks(this);
  }

  @Test
  public void questionTextDoesStuff() {
    when(this.controller.find(1)).thenReturn(new BooleanQuestion("text1"));
    when(this.controller.find(2)).thenReturn(new BooleanQuestion("text2"));

    final List<BooleanAnswer> answers = new ArrayList<>();
    answers.add(new BooleanAnswer(1, true));
    answers.add(new BooleanAnswer(2, true));

    final Map<Integer, String> questionText = this.stats.questionText(answers);

    final Map<Integer, String> expected = new HashMap<>();
    expected.put(1, "text1");
    expected.put(2, "text2");
    assertThat(questionText, equalTo(expected));
  }

  @Test
  public void responsesByQuestionAnswersCountsByQuestionText() {
    final StatCompiler stats = new StatCompiler();
    final List<BooleanAnswer> answers = new ArrayList<>();
    answers.add(new BooleanAnswer(1, true));
    answers.add(new BooleanAnswer(1, true));
    answers.add(new BooleanAnswer(1, true));
    answers.add(new BooleanAnswer(1, false));
    answers.add(new BooleanAnswer(2, true));
    answers.add(new BooleanAnswer(2, true));
    final Map<Integer, String> questions = new HashMap<>();
    questions.put(1, "Tuition reimbursement?");
    questions.put(2, "Relocation package?");

    final Map<String, Map<Boolean, AtomicInteger>> responses = stats.responsesByQuestion(
        answers, questions);

    assertThat(responses.get("Tuition reimbursement?")
                        .get(Boolean.TRUE)
                        .get(),
        equalTo(3));
    assertThat(responses.get("Tuition reimbursement?")
                        .get(Boolean.FALSE)
                        .get(),
        equalTo(1));
    assertThat(responses.get("Relocation package?")
                        .get(Boolean.TRUE)
                        .get(),
        equalTo(2));
    assertThat(responses.get("Relocation package?")
                        .get(Boolean.FALSE)
                        .get(),
        equalTo(0));
  }
}

package iloveyouboss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class AnswerCollection {

  private final Map<String, Answer> answers = new HashMap<>();

  public void add(final Answer answer) {
    this.answers.put(answer.getQuestionText(), answer);
  }

  public Answer answerMatching(final Criterion criterion) {
    return this.answers.get(criterion.getAnswer()
                                     .getQuestionText());
  }

  public List<Answer> find(final Predicate<Answer> pred) {
    return this.answers.values()
                       .stream()
                       .filter(pred)
                       .collect(Collectors.toList());
  }
}

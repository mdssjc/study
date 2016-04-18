package iloveyouboss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Profile {

  private final Map<String, Answer> answers = new HashMap<>();
  private final String              id;

  public Profile(final String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  public void add(final Answer answer) {
    this.answers.put(answer.getQuestionText(), answer);
  }

  public MatchSet getMatchSet(final Criteria criteria) {
    return new MatchSet(this.id, this.answers, criteria);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public List<Answer> find(final Predicate<Answer> pred) {
    return this.answers.values()
                       .stream()
                       .filter(pred)
                       .collect(Collectors.toList());
  }
}

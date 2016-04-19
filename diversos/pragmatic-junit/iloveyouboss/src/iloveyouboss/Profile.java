package iloveyouboss;

import java.util.List;
import java.util.function.Predicate;

public class Profile {

  private final AnswerCollection answers = new AnswerCollection();
  private final String           id;

  public Profile(final String id) {
    this.id = id;
  }

  public String getId() {
    return this.id;
  }

  public void add(final Answer answer) {
    this.answers.add(answer);
  }

  public MatchSet getMatchSet(final Criteria criteria) {
    return new MatchSet(this.id, this.answers, criteria);
  }

  @Override
  public String toString() {
    return this.id;
  }

  public List<Answer> find(final Predicate<Answer> pred) {
    return this.answers.find(pred);
  }
}

package iloveyouboss;

public class Profile {

  private final AnswerCollection answers;
  private final String           name;

  public Profile(final String name) {
    this.name = name;
    this.answers = new AnswerCollection();
  }

  public String getName() {
    return this.name;
  }

  public void add(final Answer answer) {
    this.answers.add(answer);
  }

  public MatchSet getMatchSet(final Criteria criteria) {
    return new MatchSet(this.answers, criteria);
  }

  @Override
  public String toString() {
    return this.name;
  }
}

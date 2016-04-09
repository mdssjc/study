package iloveyouboss;

import java.util.HashMap;
import java.util.Map;

public class Profile {

  private final Map<String, Answer> answers = new HashMap<>();
  private int                       score;
  private final String              name;

  public Profile(final String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void add(final Answer answer) {
    this.answers.put(answer.getQuestionText(), answer);
  }

  public boolean matches(final Criteria criteria) {
    this.score = 0;

    boolean kill = false;
    boolean anyMatches = false;
    for (final Criterion criterion : criteria) {
      final Answer answer = this.answers.get(criterion.getAnswer()
                                                      .getQuestionText());
      final boolean match = criterion.getWeight == Weight.DontCare
          || answer.match(criterion.getAnswer());

      if (!match && criterion.getWeight() == Weight.MustMatch) {
        kill = true;
      }
      if (match) {
        this.score += criterion.getWeight()
                               .getValue();
      }
      anyMatches |= match;
    }
    if (kill) {
      return false;
    }
    return anyMatches;
  }

  public int score() {
    return this.score;
  }
}

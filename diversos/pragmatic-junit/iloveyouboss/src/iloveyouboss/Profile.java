package iloveyouboss;

import java.util.HashMap;
import java.util.Map;

public class Profile {

  private final Map<String, Answer> answers = new HashMap<>();

  private Answer getMatchingProfileAnswer(final Criterion criterion) {
    return this.answers.get(criterion.getAnswer()
                                     .getQuestionText());
  }

  public boolean matches(final Criterion criteria) {
    return criteria.getWeight() == Weight.DontCare ||
        criteria.getAnswer()
                .match(getMatchingProfileAnswer(criteria));
  }

  public void add(final Answer answer) {
    this.answers.put(answer.getQuestionText(), answer);
  }

  public boolean matches(Criteria criteria) {
    boolean matches = false;
    for (Criterion criterion : criteria) {
      if (matches(criterion)) {
        matches = true;
      } else if (criterion.getWeight() == Weight.MustMatch) {
        return false;
      }
    }
    return matches;
  }

  public ProfileMatch match(Criteria criteria) {
    return new ProfileMatch();
  }
}

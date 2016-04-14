package iloveyouboss;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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

  public List<Answer> find(final Predicate<Answer> pred) {
    return this.answers.values()
                       .stream()
                       .filter(pred)
                       .collect(Collectors.toList());
  }

  public boolean matches(final Criteria criteria) {
    calculateScore(criteria);
    if (doesNotMeetAnyMustMatchCriterion(criteria)) {
      return false;
    }
    return anyMatches(criteria);
  }

  private void calculateScore(final Criteria criteria) {
    this.score = 0;
    for (final Criterion criterion : criteria) {
      if (criterion.matches(answerMatching(criterion))) {
        this.score += criterion.getWeight()
                               .getValue();
      }
    }
  }

  private boolean doesNotMeetAnyMustMatchCriterion(final Criteria criteria) {
    for (final Criterion criterion : criteria) {
      final boolean match = criterion.matches(answerMatching(criterion));
      if (!match && criterion.getWeight() == Weight.MustMatch) {
        return true;
      }
    }
    return false;
  }

  private boolean anyMatches(final Criteria criteria) {
    boolean anyMatches = false;
    for (final Criterion criterion : criteria) {
      anyMatches |= criterion.matches(answerMatching(criterion));
    }
    return anyMatches;
  }

  private Answer answerMatching(final Criterion criterion) {
    return this.answers.get(criterion.getAnswer()
                                     .getQuestionText());
  }

  public int score() {
    return this.score;
  }
}

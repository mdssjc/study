package iloveyouboss;

public class MatchSet {

  private final AnswerCollection answers;
  private final Criteria         criteria;

  public MatchSet(final AnswerCollection answers, final Criteria criteria) {
    this.answers = answers;
    this.criteria = criteria;
  }

  public boolean matches() {
    if (doesNotMeetAnyMustMatchCriterion()) {
      return false;
    }
    return anyMatches();
  }

  private boolean doesNotMeetAnyMustMatchCriterion() {
    for (final Criterion criterion : this.criteria) {
      final boolean match = criterion.matches(
          this.answers.answerMatching(criterion));
      if (!match && criterion.getWeight() == Weight.MustMatch) {
        return true;
      }
    }
    return false;
  }

  private boolean anyMatches() {
    boolean anyMatches = false;
    for (final Criterion criterion : this.criteria) {
      anyMatches |= criterion.matches(this.answers.answerMatching(criterion));
    }
    return anyMatches;
  }

  public int getScore() {
    int score = 0;
    for (final Criterion criterion : this.criteria) {
      if (criterion.matches(this.answers.answerMatching(criterion))) {
        score += criterion.getWeight()
                          .getValue();
      }
    }
    return score;
  }
}

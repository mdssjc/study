package iloveyouboss;

public class MatchSet implements Comparable<MatchSet> {

  private AnswerCollection answers;
  private final Criteria   criteria;
  private int              score = Integer.MIN_VALUE;
  private String           profileId;

  public MatchSet(final String profileId, AnswerCollection answers,
      final Criteria criteria) {
    this.profileId = profileId;
    this.answers = answers;
    this.criteria = criteria;
  }

  public MatchSet(final AnswerCollection answers, final Criteria criteria) {
    this.answers = answers;
    this.criteria = criteria;
  }

  public String getProfileId() {
    return this.profileId;
  }

  public int getScore() {
    if (this.score == Integer.MIN_VALUE) {
      calculateScore();
    }
    return this.score;
  }

  private void calculateScore() {
    this.score = 0;
    for (final Criterion criterion : this.criteria) {
      if (criterion.matches(answers.answerMatching(criterion))) {
        this.score += criterion.getWeight()
                               .getValue();
      }
    }
  }

  public boolean matches() {
    try {
      Thread.sleep(1000);
    } catch (final InterruptedException e) {
    }
    if (doesNotMeetAnyMustMatchCriterion()) {
      return false;
    }
    return anyMatches();
  }

  private boolean doesNotMeetAnyMustMatchCriterion() {
    for (final Criterion criterion : this.criteria) {
      final boolean match = criterion.matches(
          answers.answerMatching(criterion));
      if (!match && criterion.getWeight() == Weight.MustMatch) {
        return true;
      }
    }
    return false;
  }

  private boolean anyMatches() {
    boolean anyMatches = false;
    for (final Criterion criterion : this.criteria) {
      anyMatches |= criterion.matches(answers.answerMatching(criterion));
    }
    return anyMatches;
  }

  @Override
  public int compareTo(final MatchSet that) {
    return new Integer(getScore()).compareTo(new Integer(that.getScore()));
  }
}

package iloveyouboss;

public class Criterion implements Scoreable {

  private final Weight weight;
  private final Answer answer;
  private int          score;

  public Criterion(final Answer answer, final Weight weight) {
    this.answer = answer;
    this.weight = weight;
  }

  public Answer getAnswer() {
    return this.answer;
  }

  public Weight getWeight() {
    return this.weight;
  }

  public void setScore(final int score) {
    this.score = score;
  }

  @Override
  public int getScore() {
    return this.score;
  }
}

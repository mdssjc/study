package iloveyouboss;

import java.util.ArrayList;
import java.util.List;

public class ScoreCollection {

  private final List<Scoreable> scores = new ArrayList<>();

  public void add(final Scoreable scoreable) {
    this.scores.add(scoreable);
  }

  public int arithmeticMean() {
    final int total = this.scores.stream()
                                 .mapToInt(Scoreable::getScore)
                                 .sum();
    return total / this.scores.size();
  }
}

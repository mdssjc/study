package iloveyouboss;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Criteria implements Iterable<Criterion> {

  private final List<Criterion> criteria = new ArrayList<>();

  public void add(final Criterion criterion) {
    this.criteria.add(criterion);
  }

  @Override
  public Iterator<Criterion> iterator() {
    return this.criteria.iterator();
  }

  public int arithmeticMean() {
    return 0;
  }

  public double geometricMean(final int[] numbers) {
    final int totalProduct = Arrays.stream(numbers)
                                   .reduce(1,
                                       (product, number) -> product * number);
    return Math.pow(totalProduct, 1.0 / numbers.length);
  }
}

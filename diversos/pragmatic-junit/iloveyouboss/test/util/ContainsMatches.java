package util;

import java.util.List;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

public class ContainsMatches extends TypeSafeMatcher<List<Match>> {

  private final Match[] expected;

  public ContainsMatches(final Match[] expected) {
    this.expected = expected;
  }

  @Override
  public void describeTo(final Description description) {
    description.appendText("<" + this.expected.toString() + ">");
  }

  private boolean equals(final Match expected, final Match actual) {
    return expected.searchString.equals(actual.searchString)
        && expected.surroundingContext.equals(actual.surroundingContext);
  }

  @Override
  protected boolean matchesSafely(final List<Match> actual) {
    if (actual.size() != this.expected.length) {
      return false;
    }
    for (int i = 0; i < this.expected.length; i++) {
      if (!equals(this.expected[i], actual.get(i))) {
        return false;
      }
    }
    return true;
  }

  @Factory
  public static <T> Matcher<List<Match>> containsMatches(
      final Match[] expected) {
    return new ContainsMatches(expected);
  }
}

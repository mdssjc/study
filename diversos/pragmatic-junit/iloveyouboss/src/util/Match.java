package util;

public class Match {

  public final String searchString;
  public final String surroundingContext;
  public final String searchTitle;

  public Match(final String searchTitle, final String searchString,
      final String surroundingContext) {
    this.searchTitle = searchTitle;
    this.searchString = searchString;
    this.surroundingContext = surroundingContext;
  }
}

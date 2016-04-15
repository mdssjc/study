package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Search {

  private final String      searchString;
  private Exception         exception                 = null;
  private final List<Match> matches                   = new ArrayList<>();
  private int               surroundingCharacterCount = 100;
  private final InputStream inputStream;
  final static Logger       LOGGER                    = Logger.getLogger(
      Search.class.getName());
  private final String      searchTitle;

  public Search(final String urlString, final String searchString,
      final String searchTitle)
      throws IOException {
    this(new URL(urlString).openConnection()
                           .getInputStream(),
        searchString, searchTitle);
  }

  public Search(final InputStream inputStream, final String searchString,
      final String searchTitle) {
    this.inputStream = inputStream;
    this.searchString = searchString;
    this.searchTitle = searchTitle;
  }

  public List<Match> getMatches() {
    return this.matches;
  }

  public boolean errored() {
    return this.exception != null;
  }

  public Exception getError() {
    return this.exception;
  }

  public void execute() {
    try {
      search();
    } catch (final IOException exc) {
      this.exception = exc;
    }
  }

  public void setSurroundingCharacterCount(final int count) {
    this.surroundingCharacterCount = count;
  }

  private void addMatches(final String line, final Pattern pattern) {
    final Matcher matcher = pattern.matcher(line);
    while (matcher.find()) {
      int start = matcher.start();
      int end = matcher.end();
      start -= this.surroundingCharacterCount;
      if (start <= 0) {
        start = 0;
      }
      end += this.surroundingCharacterCount;
      if (end >= line.length()) {
        end = line.length();
      }
      this.matches.add(
          new Match(this.searchTitle, this.searchString,
              line.substring(start, end)));
    }
  }

  private void search() throws IOException {
    final Pattern pattern = Pattern.compile(this.searchString);
    this.matches.clear();

    Search.LOGGER.info("searching matches for pattern:" + pattern);

    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new InputStreamReader(this.inputStream));
      String line;
      while ((line = reader.readLine()) != null) {
        addMatches(line, pattern);
      }
    } finally {
      if (reader != null) {
        reader.close();
      }
    }
  }
}

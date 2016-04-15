package util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static util.ContainsMatches.containsMatches;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;

import org.junit.Before;
import org.junit.Test;

public class SearchTest {

  private static final String A_TITLE = "1";
  private InputStream         stream;

  @Before
  public void turnOffLogging() {
    Search.LOGGER.setLevel(Level.OFF);
  }

  public void closeResources() throws IOException {
    this.stream.close();
  }

  @Test
  public void returnsMatchesShowingContextWhenSearchStringInContent() {
    this.stream = streamOn("rest of text here"
        + "1234567890search term1234567890"
        + "more rest of text");
    final Search search = new Search(this.stream, "search term",
        SearchTest.A_TITLE);
    search.setSurroundingCharacterCount(10);

    search.execute();

    assertThat(search.getMatches(),
        containsMatches(new Match[] { new Match(SearchTest.A_TITLE,
            "search term", "1234567890search term1234567890") }));
  }

  @Test
  public void noMatchesReturnedWhenSearchStringNotInContent() {
    this.stream = streamOn("any text");
    final Search search = new Search(this.stream, "text that doesn't match",
        SearchTest.A_TITLE);

    search.execute();

    assertTrue(search.getMatches()
                     .isEmpty());
  }

  @Test
  public void returnsErroredWhenUnableToReadStream() {
    this.stream = createStreamThrowingErrorWhenRead();
    final Search search = new Search(this.stream, "", "");

    search.execute();

    assertTrue(search.errored());
  }

  @Test
  public void erroredReturnsFalseWhenReadSucceeds() {
    this.stream = streamOn("");
    final Search search = new Search(this.stream, "", "");

    search.execute();

    assertFalse(search.errored());
  }

  private InputStream streamOn(final String pageContent) {
    return new ByteArrayInputStream(pageContent.getBytes());
  }

  private InputStream createStreamThrowingErrorWhenRead() {
    return new InputStream() {

      @Override
      public int read() throws IOException {
        throw new IOException();
      }
    };
  }
}

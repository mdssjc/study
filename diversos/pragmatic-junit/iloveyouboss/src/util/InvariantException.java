package util;

public class InvariantException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public InvariantException(final String message) {
    super(message);
  }
}

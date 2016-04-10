package scratch;

public class InsufficientFundsException extends Exception {

  private static final long serialVersionUID = 1L;

  public InsufficientFundsException(final String message) {
    super(message);
  }
}

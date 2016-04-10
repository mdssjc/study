package scratch;

public class Account {

  private final String name;
  private int          balance;

  public Account(final String name) {
    this.name = name;
    this.balance = 0;
  }

  public boolean hasPositiveBalance() {
    return this.balance > 0;
  }

  public int getBalance() {
    return this.balance;
  }

  public void deposit(final int value) {
    this.balance += value;
  }

  public String getName() {
    return this.name;
  }

  public void withdraw(final int value) throws InsufficientFundsException {
    if (this.balance == 0) {
      throw new InsufficientFundsException("balance only 0");
    }
    if (value > this.balance) {
      throw new InsufficientFundsException("Insufficient funds");
    }
    this.balance -= value;
  }
}

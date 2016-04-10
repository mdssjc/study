package scratch;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertTest {

  private Account          account;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void createAccount() {
    account = new Account("an account name");
  }

  @Test
  public void hasPositiveBalance() {
    account.deposit(50);

    assertTrue(account.hasPositiveBalance());
    assertThat(account.getBalance() > 0, is(true));
  }

  @Test
  public void depositIncreaseBalance() {
    int initialBalance = account.getBalance();
    account.deposit(100);

    assertTrue(account.getBalance() > initialBalance);
    assertThat(account.getBalance(), equalTo(100));
  }

  @Test
  public void checkNotStartsWithXyz() {
    assertThat(account.getName(), not(startsWith("xyz")));
  }

  @Test
  public void testWithWorthlessAssertionComment() {
    account.deposit(50);
    // Incorrect message
    assertThat("account balance is 100", account.getBalance(), equalTo(50));
  }

  @Test(expected = InsufficientFundsException.class)
  public void throwsWhenWithdrawingTooMuch() throws InsufficientFundsException {
    account.withdraw(100);
  }

  @Test
  public void exceptionRule() throws InsufficientFundsException {
    thrown.expect(InsufficientFundsException.class);
    thrown.expectMessage("balance only 0");

    account.withdraw(100);
  }
}

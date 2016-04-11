package scratch;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.StringStartsWith.startsWith;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class AssertTest {

  private Account          account;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  public void createAccount() {
    this.account = new Account("an account name");
  }

  @Test
  public void hasPositiveBalance() {
    this.account.deposit(50);

    assertTrue(this.account.hasPositiveBalance());
    assertThat(this.account.getBalance() > 0, is(true));
  }

  @Test
  public void depositIncreaseBalance() {
    final int initialBalance = this.account.getBalance();
    this.account.deposit(100);

    assertTrue(this.account.getBalance() > initialBalance);
    assertThat(this.account.getBalance(), equalTo(100));
  }

  @Test
  public void checkNotStartsWithXyz() {
    assertThat(this.account.getName(), not(startsWith("xyz")));
  }

  @Test
  public void testWithWorthlessAssertionComment() {
    this.account.deposit(50);
    // Incorrect message
    assertThat("account balance is 100", this.account.getBalance(),
        equalTo(50));
  }

  @Test(expected = InsufficientFundsException.class)
  public void throwsWhenWithdrawingTooMuch() throws InsufficientFundsException {
    this.account.withdraw(100);
  }

  @Test
  public void exceptionRule() throws InsufficientFundsException {
    this.thrown.expect(InsufficientFundsException.class);
    this.thrown.expectMessage("balance only 0");

    this.account.withdraw(100);
  }

  @Test
  public void readsFromTestFile() throws IOException {
    final String filename = "test.txt";
    final BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
    writer.write("test data");
    writer.close();
  }

  @Test
  @Ignore("don't forget me!")
  public void somethingWeCannotHandleRightNow() {
    // ...
  }
}

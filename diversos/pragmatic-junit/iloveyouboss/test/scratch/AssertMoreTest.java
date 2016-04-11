package scratch;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class AssertMoreTest {

  @BeforeClass
  public static void initializeSomethingReallyExpensive() {
    System.out.println("BeforeClass initializeSomethingReallyExpensive");
  }

  @AfterClass
  public static void cleanUpSomethingReallyExpensive() {
    System.out.println("AfterClass cleanUpSomethingReallyExpensive");
  }

  @Before
  public void createAccount() {
    System.out.println("Before createAccount");
  }

  @After
  public void closeConnections() {
    System.out.println("After closeConnections");
  }

  @Test
  public void depositIncreasesBalance() {
    System.out.println("Test depositIncreasesBalance");
  }

  @Test
  public void hasPositiveBalance() {
    System.out.println("Test hasPositiveBalance");
  }
}

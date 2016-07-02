package com.github.mdssjc.handson.jbehave;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FindChangesSteps {

  private ChangeMachine cm;
  List<Integer>         change;
  Exception             error;

  @Given("a change machine")
  public void createChangeMachine() {
    cm = new ChangeMachine();
    change = null;
    error = null;
  }

  @When("I ask for change of <value>")
  @Alias("I ask for change of $value")
  public void changeFor(@Named("value") double value) {
    try {
      change = cm.getCoinsForChangeOf(value);
    } catch (Exception e) {
      error = e;
    }
  }

  @Then("it returns the <coin> coins")
  @Alias("it returns the $coin coins")
  public void changesCoins(@Named("coin") String coins) {
    String expected = "";
    for (int i = 0; i < change.size(); i++) {
      expected += change.get(i) + "c";
      if (i != change.size() - 1) {
        expected += ",";
      }
    }

    assertEquals(coins, expected);
  }

  @Then("it will raise an error")
  public void thenItWillRaiseAnError() {
    assertNotNull(error);
  }
}

package com.github.mdssjc.handson.jbehave;

import static org.junit.Assert.assertEquals;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FindChangesSteps {

  double amount;

  @Given("a change machine")
  public void createChangeMachine() {

  }

  @When("I ask for change of <value>")
  @Alias("I ask for change of $value")
  public void changeFor(@Named("value") double value) {
    this.amount = value;
  }

  @Then("it returns the <coin> coin")
  @Alias("it returns the $coin coins")
  public void changesCoins(@Named("coin") String coins) {
    assertEquals((int) (amount * 100) + "c", coins);
  }
}

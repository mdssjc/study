package com.github.mdssjc.handson.jbehave;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.jbehave.core.annotations.Alias;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Named;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class FindChangesSteps {

  private ChangeMachine cm;
  double                amount;
  List<Integer>         change;

  @Given("a change machine")
  public void createChangeMachine() {
    cm = new ChangeMachine();
  }

  @When("I ask for change of <value>")
  @Alias("I ask for change of $value")
  public void changeFor(@Named("value") double value) {
    change = cm.getCoinsForChangeOf(value);
  }

  @Then("it returns the <coin> coins")
  @Alias("it returns the $coin coins")
  public void changesCoins(@Named("coin") String coins) {
    assertEquals(coins, change.get(0) + "c");
  }
}

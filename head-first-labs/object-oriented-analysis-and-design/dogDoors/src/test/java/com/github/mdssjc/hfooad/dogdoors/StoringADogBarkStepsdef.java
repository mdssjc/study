package com.github.mdssjc.hfooad.dogdoors;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StoringADogBarkStepsdef {

  private DogDoor door;

  @Given("^Need for storing the bark\\.$")
  public void need_for_storing_the_bark() {
    this.door = new DogDoor();
  }

  @When("^The owner’s dog barks into the dog door \\(\"([^\"]*)\"\\)\\.$")
  public void the_owner_s_dog_barks_into_the_dog_door(final String bark) {
    this.door.setAllowedBark(new Bark(bark));
  }

  @Then("^The dog door stores the owner’s dog’s bark \\(\"([^\"]*)\"\\)\\.$")
  public void the_dog_door_stores_the_owner_s_dog_s_bark(final String bark) {
    assertTrue(this.door.getAllowedBark()
                        .equals(new Bark(bark)));
  }
}

package com.github.mdssjc.hfooad.dogdoors;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertTrue;

import java.util.List;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StoringADogBarkStepsdef {

  private DogDoor door;

  private List<Bark> barks;

  @Given("^The owner’s dog barks\\$ into the dog door\\.$")
  public void the_owner_s_dog_barks$_into_the_dog_door(List<String> barks) {
    this.door = new DogDoor();
    this.barks = barks.stream()
                      .map(Bark::new)
                      .collect(toList());
  }

  @When("^The dog door stores the owner’s dog’s bark\\.$")
  public void the_dog_door_stores_the_owner_s_dog_s_bark() {
    for (Bark bark : barks) {
      door.addAllowedBark(bark);
    }
  }

  @Then("^The barks\\$ are stored\\.$")
  public void the_barks$_are_stored(List<String> barks) {
    List<Bark> allowedBarks = door.getAllowedBarks();
    for (String bark : barks) {
      assertTrue(allowedBarks.contains(new Bark(bark)));
    }
  }
}

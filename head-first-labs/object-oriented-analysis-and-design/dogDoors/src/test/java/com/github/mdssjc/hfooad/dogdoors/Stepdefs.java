package com.github.mdssjc.hfooad.dogdoors;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

  private DogDoor door;
  private Remote  remote;

  @Given("^Fido starts barking\\.\\.\\.$")
  public void fido_starts_barking() {
    this.door = new DogDoor();
    remote = new Remote(door);
  }

  @When("^I press remote button$")
  public void i_press_remote_button() {
    remote.pressButton();
  }

  @Then("^The dog door opens$")
  public void the_dog_door_opens() {
    assertTrue(door.isOpen());
  }

  @Then("^Fido has gone outside\\.\\.\\.$")
  public void fido_has_gone_outside() {
    assertTrue(door.isOpen());
  }

  @Then("^Fido's all done\\.\\.\\.$")
  public void fido_s_all_done() {

  }
}

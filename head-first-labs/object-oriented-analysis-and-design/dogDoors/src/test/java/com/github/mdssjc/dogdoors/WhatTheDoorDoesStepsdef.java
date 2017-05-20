package com.github.mdssjc.dogdoors;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WhatTheDoorDoesStepsdef {

  private DogDoor door;
  private Remote remote;
  private BarkRecognizer recognizer;
  private Bark heardBark;

  @Given("^The owner’s dog barks to be let out \\(\"([^\"]*)\"\\)\\.$")
  public void the_owner_s_dog_barks_to_be_let_out(final String bark) {
    this.door = new DogDoor();
    this.remote = new Remote(this.door);
    this.recognizer = new BarkRecognizer(this.door);
    this.door.addAllowedBark(new Bark(bark));
  }

  @When("^The owner presses the button on the remote control\\.$")
  public void the_owner_presses_the_button_on_the_remote_control() {
    this.remote.pressButton();
  }

  @Then("^The dog door \"([^\"]*)\"\\.$")
  public void the_dog_door(final String option) {
    if (option.equals("opens")) {
      assertTrue(this.door.isOpen());
    } else {
      assertFalse(this.door.isOpen());
    }
  }

  @When("^The door shuts automatically\\.$")
  public void the_door_shuts_automatically() throws InterruptedException {
    while (this.door.isOpen()) {
      Thread.sleep(100);
    }
  }

  @When("^The bark recognizer hears a bark \\(\"([^\"]*)\"\\)\\.$")
  public void the_bark_recognizer_hears_a_bark(final String bark) {
    this.heardBark = new Bark(bark);
  }

  @Then("^If it’s the owner’s dog barking, the bark recognizer sends a request to the door to open\\.$")
  public void if_it_s_the_owner_s_dog_barking_the_bark_recognizer_sends_a_request_to_the_door_to_open() {
    final List<Bark> allowedBarks = this.door.getAllowedBarks();
    assertTrue(allowedBarks.contains(this.heardBark));
    this.recognizer.recognize(this.heardBark);
  }
}

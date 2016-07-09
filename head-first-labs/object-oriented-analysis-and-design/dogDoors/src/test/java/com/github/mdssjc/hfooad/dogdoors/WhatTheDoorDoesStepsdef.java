package com.github.mdssjc.hfooad.dogdoors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WhatTheDoorDoesStepsdef {

  private DogDoor        door;
  private Remote         remote;
  private BarkRecognizer recognizer;
  private Bark           heardBark;

  @Given("^The owner’s dog barks to be let out \\(\"([^\"]*)\"\\)\\.$")
  public void the_owner_s_dog_barks_to_be_let_out(String bark) {
    door = new DogDoor();
    remote = new Remote(door);
    recognizer = new BarkRecognizer(door);
    door.setAllowedBark(new Bark(bark));
  }

  @When("^The owner presses the button on the remote control\\.$")
  public void the_owner_presses_the_button_on_the_remote_control() {
    remote.pressButton();
  }

  @Then("^The dog door \"([^\"]*)\"\\.$")
  public void the_dog_door(String option) {
    if (option.equals("opens")) {
      assertTrue(door.isOpen());
    } else {
      assertFalse(door.isOpen());
    }
  }

  @When("^The door shuts automatically\\.$")
  public void the_door_shuts_automatically() throws InterruptedException {
    while (door.isOpen()) {
      Thread.sleep(100);
    }
  }

  @When("^The bark recognizer hears a bark \\(\"([^\"]*)\"\\)\\.$")
  public void the_bark_recognizer_hears_a_bark(String bark) {
    this.heardBark = new Bark(bark);
  }

  @Then("^If it’s the owner’s dog barking, the bark recognizer sends a request to the door to open\\.$")
  public void if_it_s_the_owner_s_dog_barking_the_bark_recognizer_sends_a_request_to_the_door_to_open() {
    Bark allowedBark = door.getAllowedBark();
    assertTrue(allowedBark.equals(heardBark));
    recognizer.recognize(heardBark);
  }
}

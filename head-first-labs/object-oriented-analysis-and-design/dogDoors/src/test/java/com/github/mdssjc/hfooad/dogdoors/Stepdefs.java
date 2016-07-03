package com.github.mdssjc.hfooad.dogdoors;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {

  private DogDoor        door;
  private Remote         remote;
  private BarkRecognizer recognizer;

  @Given("^Fido starts barking\\.\\.\\.$")
  public void fido_starts_barking() {
    door = new DogDoor();
    remote = new Remote(door);
    recognizer = new BarkRecognizer(door);
  }

  @When("^I press remote button$")
  public void i_press_remote_button() {
    remote.pressButton();
  }

  @Then("^The dog door \"([^\"]*)\"$")
  public void the_dog_door(String option) {
    if (option.equals("opens")) {
      assertTrue(door.isOpen());
    } else {
      assertFalse(door.isOpen());
    }
  }

  @When("^Wait a moment$")
  public void wait_a_moment() throws InterruptedException {
    while (door.isOpen()) {
      Thread.sleep(100);
    }
  }

  @When("^Recognizer hearing a bark \"([^\"]*)\"$")
  public void recognizer_hearing_a_bark(String bark) {
    recognizer.recognize(bark);
  }
}

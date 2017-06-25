package com.github.mdssjc.remote;

import com.github.mdssjc.remote.commands.GarageDoorOpenCommand;
import com.github.mdssjc.remote.commands.LightOnCommand;

public class SimpleRemoteControlTest {

  public static void main(final String[] args) {
    final SimpleRemoteControl remote = new SimpleRemoteControl();
    final Light light = new Light("Bed Room");
    final GarageDoor garageDoor = new GarageDoor("House");

    final LightOnCommand lightOn = new LightOnCommand(light);
    final GarageDoorOpenCommand garageOpen =
        new GarageDoorOpenCommand(garageDoor);

    remote.setCommand(lightOn);
    remote.buttonWasPressed();
    remote.setCommand(garageOpen);
    remote.buttonWasPressed();
  }
}

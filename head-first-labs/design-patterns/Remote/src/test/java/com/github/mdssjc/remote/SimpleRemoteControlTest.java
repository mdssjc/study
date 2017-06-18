package com.github.mdssjc.remote;

public class SimpleRemoteControlTest {

  public static void main(final String[] args) {
    final SimpleRemoteControl remote = new SimpleRemoteControl();
    final Light light = new Light("Bed Room");
    final LightOnCommand lightOn = new LightOnCommand(light);

    remote.setCommand(lightOn);
    remote.buttonWasPressed();
  }
}

package com.github.mdssjc.remote;

public class RemoteLoader {

  public static void main(final String[] args) {
    final RemoteControl remoteControl = new RemoteControl();
    final Light livingRoomLight = new Light("Living Room");
    final Light kitchenLight = new Light("Kitchen");
    final CeilingFan ceilingFan = new CeilingFan("Living Room");
    final GarageDoor garageDoor = new GarageDoor("");
    final Stereo stereo = new Stereo("Living Room");

    final LightOnCommand livingRoomLightOn =
        new LightOnCommand(livingRoomLight);
    final LightOffCommand livingRoomLightOff =
        new LightOffCommand(livingRoomLight);
    final LightOnCommand kitchenLightOn =
        new LightOnCommand(kitchenLight);
    final LightOffCommand kitchenLightOff =
        new LightOffCommand(kitchenLight);

    final CeilingFanOnCommand ceilingFanOn =
        new CeilingFanOnCommand(ceilingFan);
    final CeilingFanOffCommand ceilingFanOff =
        new CeilingFanOffCommand(ceilingFan);

    final GarageDoorUpCommand garageDoorUp =
        new GarageDoorUpCommand(garageDoor);
    final GarageDoorDownCommand garageDoorDown =
        new GarageDoorDownCommand(garageDoor);

    final StereoOnWithCDCommand stereoOnWithCD =
        new StereoOnWithCDCommand(stereo);
    final StereoOffCommand stereoOff =
        new StereoOffCommand(stereo);

    remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
    remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
    remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
    remoteControl.setCommand(3, stereoOnWithCD, stereoOff);

    System.out.println(remoteControl);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(1);
    remoteControl.offButtonWasPushed(1);
    remoteControl.onButtonWasPushed(2);
    remoteControl.offButtonWasPushed(2);
    remoteControl.onButtonWasPushed(3);
    remoteControl.offButtonWasPushed(3);
  }
}

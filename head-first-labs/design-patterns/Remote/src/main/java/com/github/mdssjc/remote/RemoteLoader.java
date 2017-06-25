package com.github.mdssjc.remote;

import com.github.mdssjc.remote.commands.*;

public class RemoteLoader {

  public static void main(final String[] args) {
    RemoteControl remoteControl = new RemoteControl();

    final Light livingRoomLight = new Light("Living Room");
    final Light kitchenLight = new Light("Kitchen");
    CeilingFan ceilingFan = new CeilingFan("Living Room");
    final GarageDoor garageDoor = new GarageDoor("");
    Stereo stereo = new Stereo("Living Room");

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
    CeilingFanOffCommand ceilingFanOff =
        new CeilingFanOffCommand(ceilingFan);

    final GarageDoorUpCommand garageDoorUp =
        new GarageDoorUpCommand(garageDoor);
    final GarageDoorDownCommand garageDoorDown =
        new GarageDoorDownCommand(garageDoor);

    final StereoOnWithCDCommand stereoOnWithCD =
        new StereoOnWithCDCommand(stereo);
    StereoOffCommand stereoOff =
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

    System.out.println();
    System.out.println("---");
    System.out.println();

    remoteControl = new RemoteControl();

    final Light livingRoom = new Light("");
    final LightOnCommand livingRoomOn = new LightOnCommand(livingRoom);
    final LightOffCommand livingRoomOff = new LightOffCommand(livingRoom);

    remoteControl.setCommand(0, livingRoomOn, livingRoomOff);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();
    remoteControl.offButtonWasPushed(0);
    remoteControl.onButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();

    System.out.println();
    System.out.println("---");
    System.out.println();

    remoteControl = new RemoteControl();

    ceilingFan = new CeilingFan("Living Room");

    final Command ceilingFanMedium = new CeilingFanMediumCommand(ceilingFan);
    final Command ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
    ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

    remoteControl.setCommand(0, ceilingFanMedium, ceilingFanOff);
    remoteControl.setCommand(1, ceilingFanHigh, ceilingFanOff);

    remoteControl.onButtonWasPushed(0);
    remoteControl.offButtonWasPushed(0);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();

    remoteControl.onButtonWasPushed(1);
    System.out.println(remoteControl);
    remoteControl.undoButtonWasPushed();

    System.out.println();
    System.out.println("---");
    System.out.println();

    remoteControl = new RemoteControl();

    Light light = new Light("Living Room");
    TV tv = new TV("Living Room");
    stereo = new Stereo("Living Room");
    Hottub hottub = new Hottub();

    Command lightOn = new LightOnCommand(light);
    Command lightOff = new LightOffCommand(light);
    Command stereoOn = new StereoOnCommand(stereo);
    stereoOff = new StereoOffCommand(stereo);
    Command tvOn = new TVOnCommand(tv);
    Command tvOff = new TVOffCommand(tv);
    Command hottubOn = new HottubOnCommand(hottub);
    Command hottubOff = new HottubOffCommand(hottub);

    Command[] partyOn = {lightOn, stereoOn, tvOn, hottubOn};
    Command[] partyOff = {lightOff, stereoOff, tvOff, hottubOff};

    MacroCommand partyOnMacro = new MacroCommand(partyOn);
    MacroCommand partyOffMacro = new MacroCommand(partyOff);

    remoteControl.setCommand(0, partyOnMacro, partyOffMacro);

    System.out.println(remoteControl);
    System.out.println("--- Pushing Macro On---");
    remoteControl.onButtonWasPushed(0);
    System.out.println("--- Pushing Macro Off---");
    remoteControl.offButtonWasPushed(0);
  }
}

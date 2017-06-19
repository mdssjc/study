package com.github.mdssjc.remote;

public class CeilingFan {

  private final String location;
  private Level speed;

  public CeilingFan(final String location) {
    this.location = location;
    this.speed = Level.OFF;
  }

  public void high() {
    this.speed = Level.HIGH;
    System.out.println(this.location + " ceiling fan is on high");
  }

  public void medium() {
    this.speed = Level.MEDIUM;
    System.out.println(this.location + " ceiling fan is on medium");
  }

  public void low() {
    this.speed = Level.LOW;
    System.out.println(this.location + " ceiling fan is on low");
  }

  public void off() {
    this.speed = Level.OFF;
    System.out.println(this.location + " ceiling fan is off");
  }

  public Level getSpeed() {
    return this.speed;
  }

  public enum Level {
    OFF, LOW, MEDIUM, HIGH
  }
}

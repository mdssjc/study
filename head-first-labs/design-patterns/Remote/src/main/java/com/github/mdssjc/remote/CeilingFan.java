package com.github.mdssjc.remote;

public class CeilingFan {

  public static final int HIGH = 2;
  public static final int MEDIUM = 1;
  public static final int LOW = 0;
  private String location = "";
  private int level;

  public CeilingFan(final String location) {
    this.location = location;
  }

  public void high() {
    // turns the ceiling fan on to high
    this.level = HIGH;
    System.out.println(this.location + " ceiling fan is on high");
  }

  public void medium() {
    // turns the ceiling fan on to medium
    this.level = MEDIUM;
    System.out.println(this.location + " ceiling fan is on medium");
  }

  public void low() {
    // turns the ceiling fan on to low
    this.level = LOW;
    System.out.println(this.location + " ceiling fan is on low");
  }

  public void off() {
    // turns the ceiling fan off
    this.level = 0;
    System.out.println(this.location + " ceiling fan is off");
  }

  public int getSpeed() {
    return this.level;
  }
}

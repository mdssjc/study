package com.github.mdssjc.remote;

public class Light {

  private final String location;

  public Light(final String location) {
    this.location = location;
  }

  public void on() {
    System.out.println(this.location + " light is on");
  }

  public void off() {
    System.out.println(this.location + " light is off");
  }
}

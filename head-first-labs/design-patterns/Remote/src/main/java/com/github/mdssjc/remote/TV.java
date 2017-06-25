package com.github.mdssjc.remote;

public class TV {

  private final String location;

  public TV(final String location) {
    this.location = location;
  }

  public void on() {
    System.out.println(this.location + " TV is on");
    System.out.println(this.location + " TV channel is set for DVD");
  }

  public void off() {
    System.out.println(this.location + " TV is off");
  }
}

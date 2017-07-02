package com.github.mdssjc.hometheater;

class Projector {

  private final String description;
  private final DvdPlayer dvdPlayer;

  public Projector(final String description, final DvdPlayer dvdPlayer) {
    this.description = description;
    this.dvdPlayer = dvdPlayer;
  }

  public void on() {
    System.out.println(this.description + " on");
  }

  public void off() {
    System.out.println(this.description + " off");
  }

  public void wideScreenMode() {
    System.out.println(
        this.description + " in widescreen mode (16x9 aspect ratio)");
  }

  public void tvMode() {
    System.out.println(this.description + " in tv mode (4x3 aspect ratio)");
  }

  @Override
  public String toString() {
    return this.description;
  }
}

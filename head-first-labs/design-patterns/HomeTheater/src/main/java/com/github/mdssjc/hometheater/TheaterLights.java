package com.github.mdssjc.hometheater;

class TheaterLights {

  private final String description;

  public TheaterLights(final String description) {
    this.description = description;
  }

  public void on() {
    System.out.println(this.description + " on");
  }

  public void off() {
    System.out.println(this.description + " off");
  }

  public void dim(final int level) {
    System.out.println(this.description + " dimming to " + level + "%");
  }

  @Override
  public String toString() {
    return this.description;
  }
}

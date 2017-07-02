package com.github.mdssjc.hometheater;

class PopcornPopper {

  private final String description;

  public PopcornPopper(final String description) {
    this.description = description;
  }

  public void on() {
    System.out.println(this.description + " on");
  }

  public void off() {
    System.out.println(this.description + " off");
  }

  public void pop() {
    System.out.println(this.description + " popping popcorn!");
  }

  @Override
  public String toString() {
    return this.description;
  }
}

package com.github.mdssjc.hometheater;

class Screen {

  private final String description;

  public Screen(final String description) {
    this.description = description;
  }

  public void up() {
    System.out.println(this.description + " going up");
  }

  public void down() {
    System.out.println(this.description + " going down");
  }

  @Override
  public String toString() {
    return this.description;
  }
}

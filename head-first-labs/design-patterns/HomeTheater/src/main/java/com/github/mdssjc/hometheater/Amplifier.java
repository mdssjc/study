package com.github.mdssjc.hometheater;

public class Amplifier {

  private final String description;
  private Tuner tuner;
  private DvdPlayer dvd;
  private CdPlayer cd;

  public Amplifier(final String description) {
    this.description = description;
  }

  public void on() {
    System.out.println(this.description + " on");
  }

  public void off() {
    System.out.println(this.description + " off");
  }

  public void setStereoSound() {
    System.out.println(this.description + " stereo mode on");
  }

  public void setSurroundSound() {
    System.out.println(
        this.description + " surround sound on (5 speakers, 1 subwoofer)");
  }

  public void setVolume(final int level) {
    System.out.println(this.description + " setting volume to " + level);
  }

  public void setTuner(final Tuner tuner) {
    System.out.println(this.description + " setting tuner to " + this.dvd);
    this.tuner = tuner;
  }

  public void setDvd(final DvdPlayer dvd) {
    System.out.println(this.description + " setting DVD player to " + dvd);
    this.dvd = dvd;
  }

  public void setCd(final CdPlayer cd) {
    System.out.println(this.description + " setting CD player to " + cd);
    this.cd = cd;
  }

  @Override
  public String toString() {
    return this.description;
  }
}

package com.github.mdssjc.hometheater;

public class CdPlayer {

  private final String description;
  private final Amplifier amplifier;
  private int currentTrack;
  private String title;

  public CdPlayer(final String description, final Amplifier amplifier) {
    this.description = description;
    this.amplifier = amplifier;
  }

  public void on() {
    System.out.println(this.description + " on");
  }

  public void off() {
    System.out.println(this.description + " off");
  }

  public void eject() {
    this.title = null;
    System.out.println(this.description + " eject");
  }

  public void play(final String title) {
    this.title = title;
    this.currentTrack = 0;
    System.out.println(this.description + " playing \"" + title + "\"");
  }

  public void play(final int track) {
    if (this.title == null) {
      System.out.println(
          this.description + " can't play track " + this.currentTrack +
          ", no cd inserted");
    } else {
      this.currentTrack = track;
      System.out.println(
          this.description + " playing track " + this.currentTrack);
    }
  }

  public void stop() {
    this.currentTrack = 0;
    System.out.println(this.description + " stopped");
  }

  public void pause() {
    System.out.println(this.description + " paused \"" + this.title + "\"");
  }

  @Override
  public String toString() {
    return this.description;
  }
}

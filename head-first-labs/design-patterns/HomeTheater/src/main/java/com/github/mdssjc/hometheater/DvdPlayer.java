package com.github.mdssjc.hometheater;

public class DvdPlayer {

  private final String description;
  private final Amplifier amplifier;
  private int currentTrack;
  private String movie;

  public DvdPlayer(final String description, final Amplifier amplifier) {
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
    this.movie = null;
    System.out.println(this.description + " eject");
  }

  public void play(final String movie) {
    this.movie = movie;
    this.currentTrack = 0;
    System.out.println(this.description + " playing \"" + movie + "\"");
  }

  public void play(final int track) {
    if (this.movie == null) {
      System.out.println(
          this.description + " can't play track " + track + " no dvd inserted");
    } else {
      this.currentTrack = track;
      System.out.println(
          this.description + " playing track " + this.currentTrack + " of \"" + this.movie + "\"");
    }
  }

  public void stop() {
    this.currentTrack = 0;
    System.out.println(this.description + " stopped \"" + this.movie + "\"");
  }

  public void pause() {
    System.out.println(this.description + " paused \"" + this.movie + "\"");
  }

  public void setTwoChannelAudio() {
    System.out.println(this.description + " set two channel audio");
  }

  public void setSurroundAudio() {
    System.out.println(this.description + " set surround audio");
  }

  @Override
  public String toString() {
    return this.description;
  }
}

package com.github.mdssjc.hometheater;

public class HomeTheaterTestDrive {

  public static void main(final String[] args) {
    final Amplifier amp = new Amplifier("Top-O-Line Amplifier");
    final Tuner tuner = new Tuner("Top-O-Line AM/FM Tuner", amp);
    final DvdPlayer dvd = new DvdPlayer("Top-O-Line DVD Player", amp);
    final CdPlayer cd = new CdPlayer("Top-O-Line CD Player", amp);
    final Projector projector = new Projector("Top-O-Line Projector", dvd);
    final TheaterLights lights = new TheaterLights("Theater Ceiling Lights");
    final Screen screen = new Screen("Theater Screen");
    final PopcornPopper popper = new PopcornPopper("Popcorn Popper");

    final HomeTheaterFacade homeTheater = new HomeTheaterFacade(amp, tuner, dvd,
                                                                cd, projector,
                                                                screen, lights,
                                                                popper);
    homeTheater.watchMovie("Raiders of the Lost Ark");
    homeTheater.endMovie();
  }
}

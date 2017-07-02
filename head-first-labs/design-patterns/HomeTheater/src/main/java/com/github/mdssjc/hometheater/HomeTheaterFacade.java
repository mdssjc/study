package com.github.mdssjc.hometheater;

public class HomeTheaterFacade {

  private final Amplifier amp;
  private final Tuner tuner;
  private final DvdPlayer dvd;
  private final CdPlayer cd;
  private final Projector projector;
  private final TheaterLights lights;
  private final Screen screen;
  private final PopcornPopper popper;

  public HomeTheaterFacade(final Amplifier amp, final Tuner tuner, final DvdPlayer dvd,
                           final CdPlayer cd, final Projector projector,
                           final Screen screen, final TheaterLights lights,
                           final PopcornPopper popper) {
    this.amp = amp;
    this.tuner = tuner;
    this.dvd = dvd;
    this.cd = cd;
    this.projector = projector;
    this.screen = screen;
    this.lights = lights;
    this.popper = popper;
  }

  public void watchMovie(final String movie) {
    System.out.println("Get ready to watch a movie...");
    this.popper.on();
    this.popper.pop();
    this.lights.dim(10);
    this.screen.down();
    this.projector.on();
    this.projector.wideScreenMode();
    this.amp.on();
    this.amp.setDvd(this.dvd);
    this.amp.setSurroundSound();
    this.amp.setVolume(5);
    this.dvd.on();
    this.dvd.play(movie);
  }

  public void endMovie() {
    System.out.println("Shutting movie theater down...");
    this.popper.off();
    this.lights.on();
    this.screen.up();
    this.projector.off();
    this.amp.off();
    this.dvd.stop();
    this.dvd.eject();
    this.dvd.off();
  }
}

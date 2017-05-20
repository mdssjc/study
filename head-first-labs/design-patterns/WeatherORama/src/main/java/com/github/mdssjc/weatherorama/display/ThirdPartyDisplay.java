package com.github.mdssjc.weatherorama.display;

import com.github.mdssjc.weatherorama.DisplayElement;
import com.github.mdssjc.weatherorama.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class ThirdPartyDisplay implements Observer, DisplayElement {

  private final Observable observable;

  public ThirdPartyDisplay(final Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(final Observable observable, final Object arg) {
    if (observable instanceof WeatherData) {
      final WeatherData weatherData = (WeatherData) observable;

      display();
    }
  }

  @Override
  public void display() {

  }
}

package com.github.mdssjc.weatherorama.display;

import com.github.mdssjc.weatherorama.DisplayElement;
import com.github.mdssjc.weatherorama.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

  private final Observable observable;
  private float temperature;
  private float humidity;

  public CurrentConditionsDisplay(final Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(final Observable observable, final Object arg) {
    if (observable instanceof WeatherData) {
      final WeatherData weatherData = (WeatherData) observable;

      this.temperature = weatherData.getTemperature();
      this.humidity = weatherData.getHumidity();

      display();
    }
  }

  @Override
  public void display() {
    System.out.printf("Current conditions: %.1fF degrees and %.1f%% humidity%n",
                      this.temperature, this.humidity);
  }
}

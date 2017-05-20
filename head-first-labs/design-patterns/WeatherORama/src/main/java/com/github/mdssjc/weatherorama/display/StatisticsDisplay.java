package com.github.mdssjc.weatherorama.display;

import com.github.mdssjc.weatherorama.DisplayElement;
import com.github.mdssjc.weatherorama.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class StatisticsDisplay implements Observer, DisplayElement {

  private final Observable observable;
  private float maxTemp = 0.0f;
  private float minTemp = 200;
  private float tempSum = 0.0f;
  private int numReadings;

  public StatisticsDisplay(final Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(final Observable observable, final Object arg) {
    if (observable instanceof WeatherData) {
      final WeatherData weatherData = (WeatherData) observable;

      final float temperature = weatherData.getTemperature();

      this.tempSum += temperature;
      this.numReadings++;

      if (temperature > this.maxTemp) {
        this.maxTemp = temperature;
      }

      if (temperature < this.minTemp) {
        this.minTemp = temperature;
      }

      display();
    }
  }

  public void display() {
    System.out.printf("Avg/Max/Min temperature = %.1f/%.1f/%.1f%n",
                      (this.tempSum / this.numReadings), this.maxTemp,
                      this.minTemp);
  }
}

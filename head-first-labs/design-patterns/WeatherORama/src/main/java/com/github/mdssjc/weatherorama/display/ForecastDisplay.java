package com.github.mdssjc.weatherorama.display;

import com.github.mdssjc.weatherorama.DisplayElement;
import com.github.mdssjc.weatherorama.WeatherData;

import java.util.Observable;
import java.util.Observer;

public class ForecastDisplay implements Observer, DisplayElement {

  private final Observable observable;
  private float currentPressure = 29.92f;
  private float lastPressure;

  public ForecastDisplay(final Observable observable) {
    this.observable = observable;
    observable.addObserver(this);
  }

  @Override
  public void update(final Observable observable, final Object arg) {
    if (observable instanceof WeatherData) {
      final WeatherData weatherData = (WeatherData) observable;

      this.lastPressure = this.currentPressure;
      this.currentPressure = weatherData.getPressure();

      display();
    }
  }

  public void display() {
    System.out.print("Forecast: ");
    if (this.currentPressure > this.lastPressure) {
      System.out.println("Improving weather on the way!");
    } else if (this.currentPressure == this.lastPressure) {
      System.out.println("More of the same");
    } else if (this.currentPressure < this.lastPressure) {
      System.out.println("Watch out for cooler, rainy weather");
    }
  }
}

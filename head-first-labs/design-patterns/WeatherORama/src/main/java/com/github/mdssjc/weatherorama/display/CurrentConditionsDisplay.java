package com.github.mdssjc.weatherorama.display;

import com.github.mdssjc.weatherorama.DisplayElement;
import com.github.mdssjc.weatherorama.Observer;
import com.github.mdssjc.weatherorama.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

  private final Subject weatherData;
  private float temperature;
  private float humidity;

  public CurrentConditionsDisplay(Subject weatherData) {
    this.weatherData = weatherData;
    weatherData.registerObserver(this);
  }

  @Override
  public void update(float temp, float humidity, float pressure) {
    temperature = temp;
    this.humidity = humidity;
    display();
  }

  @Override
  public void display() {
    System.out.printf("Current conditions: %.1fF degrees and %.1f%% humidity%n",
                      temperature, humidity);
  }
}

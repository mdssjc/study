package com.github.mdssjc.weatherorama;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

  private float temperature;
  private float humidity;
  private final Subject weatherData;

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

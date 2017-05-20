package com.github.mdssjc.weatherorama;

import com.github.mdssjc.weatherorama.display.CurrentConditionsDisplay;
import com.github.mdssjc.weatherorama.display.ForecastDisplay;
import com.github.mdssjc.weatherorama.display.HeatIndexDisplay;
import com.github.mdssjc.weatherorama.display.StatisticsDisplay;

public class WeatherStation {

  public static void main(final String[] args) {
    final WeatherData weatherData = new WeatherData();

    final CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay(
        weatherData);
    final StatisticsDisplay statisticsDisplay = new StatisticsDisplay(
        weatherData);
    final ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
    final HeatIndexDisplay heatIndexDisplay = new HeatIndexDisplay(weatherData);

    weatherData.setMeasurements(80, 65, 30.4f);
    weatherData.setMeasurements(82, 70, 29.2f);
    weatherData.setMeasurements(78, 90, 29.2f);
  }
}

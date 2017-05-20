package com.github.mdssjc.weatherorama;

public interface Observer {

  void update(float temp, float humidity, float pressure);
}

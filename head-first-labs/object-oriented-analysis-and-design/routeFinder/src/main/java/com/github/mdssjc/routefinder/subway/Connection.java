package com.github.mdssjc.routefinder.subway;

public class Connection {

  private final Station station1;
  private final Station station2;
  private final String  lineName;

  public Connection(final Station station1, final Station station2,
      final String lineName) {
    this.station1 = station1;
    this.station2 = station2;
    this.lineName = lineName;
  }

  public Station getStation1() {
    return this.station1;
  }

  public Station getStation2() {
    return this.station2;
  }

  public String getLineName() {
    return this.lineName;
  }
}

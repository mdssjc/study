package com.github.mdssjc.routefinder.subway;

import java.util.LinkedList;
import java.util.List;

public class Subway {

  private final List<Station>    stations;
  private final List<Connection> connections;

  public Subway() {
    this.stations = new LinkedList<>();
    this.connections = new LinkedList<>();
  }

  public void addStation(final String stationName) {
    if (!this.hasStation(stationName)) {
      final Station station = new Station(stationName);
      this.stations.add(station);
    }
  }

  public boolean hasStation(final String stationName) {
    return this.stations.contains(new Station(stationName));
  }

  public void addConnection(final String station1Name,
      final String station2Name, final String lineName) {
    if ((this.hasStation(station1Name)) && (this.hasStation(station2Name))) {
      final Station station1 = new Station(station1Name);
      final Station station2 = new Station(station2Name);
      final Connection connection = new Connection(station1, station2,
          lineName);
      this.connections.add(connection);
      this.connections
        .add(new Connection(station2, station1, connection.getLineName()));
    } else {
      throw new RuntimeException("Invalid connection!");
    }
  }

  public boolean hasConnection(final String station1Name,
      final String station2Name, final String lineName) {
    final Station station1 = new Station(station1Name);
    final Station station2 = new Station(station2Name);
    for (final Connection connection : this.connections) {
      if (connection.getLineName()
        .equalsIgnoreCase(lineName)
          && connection.getStation1()
            .equals(station1)
          && connection.getStation2()
            .equals(station2)) {
        return true;
      }
    }
    return false;
  }
}

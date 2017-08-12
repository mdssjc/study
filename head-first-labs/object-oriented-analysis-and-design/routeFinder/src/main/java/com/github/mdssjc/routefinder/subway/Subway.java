package com.github.mdssjc.routefinder.subway;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Subway {

  private final List<Station>               stations;
  private final List<Connection>            connections;
  private final Map<Station, List<Station>> network;

  public Subway() {
    this.stations = new LinkedList<>();
    this.connections = new LinkedList<>();
    this.network = new HashMap<>();
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

  public Connection addConnection(final String station1Name,
      final String station2Name, final String lineName) {
    if ((this.hasStation(station1Name)) && (this.hasStation(station2Name))) {
      final Station station1 = new Station(station1Name);
      final Station station2 = new Station(station2Name);
      final Connection connection = new Connection(station1, station2,
          lineName);
      this.connections.add(connection);
      this.connections
        .add(new Connection(station2, station1, connection.getLineName()));
      addToNetwork(station1, station2);
      addToNetwork(station2, station1);
      return connection;
    }
    throw new RuntimeException("Invalid connection!");
  }

  private void addToNetwork(final Station station2, final Station station1) {
    if (this.network.keySet()
      .contains(station1)) {
      final List<Station> connectingStations = this.network.get(station1);
      if (!connectingStations.contains(station2)) {
        connectingStations.add(station2);
      }
    } else {
      final LinkedList<Station> connectingStations = new LinkedList<>();
      connectingStations.add(station2);
      this.network.put(station1, connectingStations);
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

  public List<Connection> getDirections(final String startStationName,
      final String endStationName) {
    if (!this.hasStation(startStationName)
        || !this.hasStation(endStationName)) {
      throw new RuntimeException(
          "Stations entered do not exist on this subway.");
    }

    final Station start = new Station(startStationName);
    final Station end = new Station(endStationName);
    final List<Connection> route = new LinkedList<>();
    final List<Station> reachableStations = new LinkedList<>();
    final Map<Station, Station> previousStations = new HashMap<>();

    final List<Station> neighbors = this.network.get(start);
    for (final Station station : neighbors) {
      if (station.equals(end)) {
        route.add(getConnection(start, end));
        return route;
      }
      reachableStations.add(station);
      previousStations.put(station, start);
    }

    List<Station> nextStations = new LinkedList<>();
    nextStations.addAll(neighbors);
    Station currentStation = start;

    searchLoop: for (int i = 1; i < this.stations.size(); i++) {
      final List<Station> tmpNextStations = new LinkedList<>();
      for (final Station station : nextStations) {
        reachableStations.add(station);
        currentStation = station;
        final List<Station> currentNeighbors = this.network.get(currentStation);
        for (final Station neighbor : currentNeighbors) {
          if (neighbor.equals(end)) {
            reachableStations.add(neighbor);
            previousStations.put(neighbor, currentStation);
            break searchLoop;
          } else if (!reachableStations.contains(neighbor)) {
            reachableStations.add(neighbor);
            tmpNextStations.add(neighbor);
            previousStations.put(neighbor, currentStation);
          }
        }
      }
      nextStations = tmpNextStations;
    }

    // We’ve found the path by now
    boolean keepLooping = true;
    Station keyStation = end;
    Station station;
    while (keepLooping) {
      station = previousStations.get(keyStation);
      route.add(0, getConnection(station, keyStation));
      if (start.equals(station)) {
        keepLooping = false;
      }
      keyStation = station;
    }
    return route;
  }

  private Connection getConnection(final Station station1,
      final Station station2) {
    for (final Connection connection : this.connections) {
      final Station one = connection.getStation1();
      final Station two = connection.getStation2();
      if ((station1.equals(one)) && (station2.equals(two))) {
        return connection;
      }
    }
    return null;
  }
}

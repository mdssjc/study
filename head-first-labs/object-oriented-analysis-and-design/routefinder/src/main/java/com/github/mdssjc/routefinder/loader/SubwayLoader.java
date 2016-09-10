package com.github.mdssjc.routefinder.loader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.github.mdssjc.routefinder.subway.Subway;

public class SubwayLoader {

  private final Subway subway;

  public SubwayLoader() {
    this.subway = new Subway();
  }

  public Subway loadFromFile(final File subwayFile) throws IOException {
    try (final BufferedReader reader = new BufferedReader(
        new FileReader(subwayFile))) {
      loadStations(this.subway, reader);
      String lineName = reader.readLine();
      while ((lineName != null) && (lineName.length() > 0)) {
        loadLine(this.subway, reader, lineName);
        lineName = reader.readLine();
      }
      return this.subway;
    }
  }

  private static void loadStations(final Subway subway,
      final BufferedReader reader) throws IOException {
    String currentLine;
    currentLine = reader.readLine();
    while (currentLine.length() > 0) {
      subway.addStation(currentLine);
      currentLine = reader.readLine();
    }
  }

  private static void loadLine(final Subway subway, final BufferedReader reader,
      final String lineName) throws IOException {
    String station1Name = reader.readLine();
    String station2Name = reader.readLine();
    while ((station2Name != null) && (station2Name.length() > 0)) {
      subway.addConnection(station1Name, station2Name, lineName);
      station1Name = station2Name;
      station2Name = reader.readLine();
    }
  }
}

package com.github.mdssjc.routefinder;

import com.github.mdssjc.routefinder.loader.SubwayLoader;
import com.github.mdssjc.routefinder.printer.SubwayPrinter;
import com.github.mdssjc.routefinder.subway.Connection;
import com.github.mdssjc.routefinder.subway.Subway;

import java.io.File;
import java.util.List;

public class SubwayTester {

  public static void main(final String[] args) {
    if (args.length != 2) {
      System.err.println("Usage: SubwayTester [startStation] [endStation]");
      System.exit(-1);
    }

    try {
      final SubwayLoader loader = new SubwayLoader();
      final String file = ClassLoader.getSystemResource("ObjectvilleSubway.txt")
                                     .getPath();
      final Subway objectville = loader
          .loadFromFile(new File(file));

      if (!objectville.hasStation(args[0])) {
        System.err.println(args[0] + " is not a station in Objectville.");
        System.exit(-1);
      } else if (!objectville.hasStation(args[1])) {
        System.err.println(args[1] + " is not a station in Objectville.");
        System.exit(-1);
      }

      final List<Connection> route = objectville.getDirections(args[0],
                                                               args[1]);
      final SubwayPrinter printer = new SubwayPrinter(System.out);
      printer.printDirections(route);
    } catch (final Exception e) {
      e.printStackTrace(System.out);
    }
  }
}

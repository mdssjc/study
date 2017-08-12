package com.github.mdssjc.routefinder.printer;

import com.github.mdssjc.routefinder.subway.Connection;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class SubwayPrinter {

  private final PrintStream out;

  public SubwayPrinter(final OutputStream out) {
    this.out = new PrintStream(out);
  }

  public void printDirections(final List<Connection> route) {
    Connection connection = route.get(0);
    String currentLine = connection.getLineName();
    String previousLine = currentLine;
    this.out.println("Start out at " + connection.getStation1()
                                                 .getName() + ".");
    this.out.println(
        "Get on the " + currentLine + " heading towards " + connection.getStation2()
                                                                      .getName() + ".");

    for (int i = 1; i < route.size(); i++) {
      connection = route.get(i);
      currentLine = connection.getLineName();
      if (currentLine.equals(previousLine)) {
        this.out.println(" Continue past " + connection.getStation1()
                                                       .getName() + "...");
      } else {
        this.out.println("When you get to " + connection.getStation1()
                                                        .getName() + ", get off the " + previousLine + ".");
        this.out.println(
            "Switch over to the " + currentLine + ", heading towards " + connection.getStation2()
                                                                                   .getName() + ".");
        previousLine = currentLine;
      }
    }

    this.out.println("Get off at " + connection.getStation2()
                                               .getName() + " and enjoy yourself!");
  }
}

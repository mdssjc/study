package com.github.mdssjc.routefinder;

import com.github.mdssjc.routefinder.loader.SubwayLoader;
import com.github.mdssjc.routefinder.subway.Subway;

import java.io.File;

public class LoadTester {

  public static void main(final String[] args) {
    try {
      final SubwayLoader loader = new SubwayLoader();
      final String file = ClassLoader.getSystemResource("ObjectvilleSubway.txt")
                                     .getPath();
      final Subway objectville = loader.loadFromFile(new File(file));

      System.out.println("Testing stations...");
      if (objectville.hasStation("DRY Drive") &&
          objectville.hasStation("Weather-O-Rama, Inc.") &&
          objectville.hasStation("Boards 'R' Us")) {
        System.out.println("...station test passed successfully.");
      } else {
        System.out.println("...station test FAILED.");
        System.exit(-1);
      }

      System.out.println("\nTesting connections...");
      if (objectville.hasConnection("DRY Drive",
                                    "Head First Theater", "Meyer Line") &&
          objectville.hasConnection("Weather-O-Rama, Inc.",
                                    "XHTML Expressway", "Wirfs-Brock Line") &&

          objectville.hasConnection("Head First Theater",
                                    "Infinite Circle", "Rumbaugh Line")) {
        System.out.println("...connections test passed successfully.");
      } else {
        System.out.println("...connections test FAILED.");
        System.exit(-1);
      }
    } catch (final Exception e) {
      e.printStackTrace(System.out);
    }
  }
}

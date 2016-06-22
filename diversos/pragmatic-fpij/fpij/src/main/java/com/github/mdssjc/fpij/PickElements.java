package com.github.mdssjc.fpij;

import static com.github.mdssjc.fpij.Folks.friends;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PickElements {

  public static void main(final String[] args) {
    {
      final List<String> startsWithN = new ArrayList<>();
      for (String name : friends) {
        if (name.startsWith("N")) {
          startsWithN.add(name);
        }
      }

      System.out.println(String.format("Found %d names", startsWithN.size()));
    }

    System.out.println("//" + "START:FILTER_OUTPUT");
    final List<String> startsWithN = friends.stream()
                                            .filter(
                                                name -> name.startsWith("N"))
                                            .collect(Collectors.toList());

    System.out.println(String.format("Found %d names", startsWithN.size()));

    System.out.println("//" + "END:FILTER_OUTPUT");
  }
}

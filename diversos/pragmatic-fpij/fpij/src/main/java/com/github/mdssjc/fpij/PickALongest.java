package com.github.mdssjc.fpij;

import static com.github.mdssjc.fpij.Folks.friends;

import java.util.Optional;

public class PickALongest {

  public static void main(final String[] args) {
    {
      System.out.println("//" + "START:SUM_OUTPUT");
      System.out.println("Total number of characters in all names: " +
          friends.stream()
                 .mapToInt(name -> name.length())
                 .sum());
    }
    System.out.println("//" + "END:SUM_OUTPUT");

    System.out.println("//" + "END:AVERAGE_OUTPUT");
    System.out.println("//" + "START:REDUCE_OUTPUT");
    final Optional<String> aLongName = friends.stream()
                                              .reduce((name1,
                                                  name2) -> name1.length() >= name2.length()
                                                      ? name1 : name2);
    aLongName.ifPresent(
        name -> System.out.println(String.format("A longest name: %s", name)));
    System.out.println("//" + "END:REDUCE_OUTPUT");

    final String steveOrLonger = friends.stream()
                                        .reduce("Steve",
                                            (name1,
                                                name2) -> name1.length() >= name2.length()
                                                    ? name1 : name2);

    System.out.println(steveOrLonger);
  }
}

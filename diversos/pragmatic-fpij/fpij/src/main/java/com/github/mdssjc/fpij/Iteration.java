package com.github.mdssjc.fpij;

import static com.github.mdssjc.fpij.Folks.friends;

import java.util.function.Consumer;

public class Iteration {

  public static void main(final String[] args) {
    for (int i = 0; i < friends.size(); i++) {
      System.out.println(friends.get(i));
    }

    for (String name : friends) {
      System.out.println(name);
    }

    System.out.println("//" + "START:INTERNAL_FOR_EACH_OUTPUT");

    friends.forEach(new Consumer<String>() {

      @Override
      public void accept(final String name) {
        System.out.println(name);
      }
    });

    System.out.println("//" + "END:INTERNAL_FOR_EACH_OUTPUT");

    System.out.println("//" + "START:INTERNAL_OUTPUT");
    friends.forEach((final String name) -> System.out.println(name));
    System.out.println("//" + "END:INTERNAL_OUTPUT");

    friends.forEach((name) -> System.out.println(name));

    friends.forEach(name -> System.out.println(name));

    friends.forEach(System.out::println);
  }
}

package com.mysql.mdssjc.speedment;

import java.util.Scanner;
import java.util.stream.Collectors;

import com.company.hellospeedment.HellospeedmentApplication;
import com.company.hellospeedment.db0.hellospeedment.user.User;
import com.company.hellospeedment.db0.hellospeedment.user.generated.GeneratedUser;
import com.speedment.Speedment;
import com.speedment.exception.SpeedmentException;
import com.speedment.manager.Manager;

/**
 *
 * @author Marcelo dos Santos
 */
public class Main {

  public static void main(final String... param) {
    final Speedment speedment = new HellospeedmentApplication().withPassword(
        "12345")
                                                               .build();
    final Manager<User> users = speedment.managerOf(User.class);

    final Scanner scn = new Scanner(System.in);

    System.out.print("What is your name? ");
    final String name = scn.nextLine();

    System.out.print("What is your age? ");
    final int age = scn.nextInt();

    try {
      users.newEmptyEntity()
           .setName(name)
           .setAge(age)
           .persist();
    } catch (final SpeedmentException ex) {
      System.out.println("That name was already taken.");
    }

    System.out.println(
        users.stream()
             .filter(GeneratedUser.ID.lessThan(100L))
             .map(User::toJson)
             .collect(Collectors.joining(",n    ", "[n    ", "n]")));
  }
}

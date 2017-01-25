package com.github.mdssjc.dp.null_object.base;

import com.github.mdssjc.dp.null_object.resource.Device;
import com.github.mdssjc.dp.null_object.resource.Message;

import java.util.Optional;

/**
 * Test drive do padrão de projeto Null Object.
 * <p>
 * Design Pattern
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final Device device = new Device();

    final String message1 = device.message1();
    final Optional<String> result1 = Optional.ofNullable(message1);
    System.out.println(result1.orElse("Sem dados..."));

    final String message2 = device.message2();
    System.out.println(message2);

    final Message message3 = device.message3();
    System.out.println(message3.say());

    final Message message4 = device.message4();
    System.out.println(message4.say());
  }
}

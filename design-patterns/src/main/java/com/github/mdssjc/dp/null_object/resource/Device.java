package com.github.mdssjc.dp.null_object.resource;

/**
 * Implementação do Device.
 *
 * @author Marcelo dos Santos
 *
 */
public class Device {

  public String message1() {
    return null;
  }

  public String message2() {
    return "Mensagem 2...";
  }

  public Message message3() {
    return new NullObject();
  }

  public Message message4() {
    return () -> "Mensagem 4...";
  }
}

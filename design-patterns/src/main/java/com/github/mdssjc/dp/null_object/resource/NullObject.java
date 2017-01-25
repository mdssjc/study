package com.github.mdssjc.dp.null_object.resource;

/**
 * Implementação do NullObject.
 *
 * @author Marcelo dos Santos
 *
 */
public class NullObject implements Message {

  @Override
  public String say() {
    return "Sem dados...";
  }
}

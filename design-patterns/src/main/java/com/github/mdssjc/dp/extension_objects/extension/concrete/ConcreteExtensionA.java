package com.github.mdssjc.dp.extension_objects.extension.concrete;

import com.github.mdssjc.dp.extension_objects.concrete.ConcreteSubject;
import com.github.mdssjc.dp.extension_objects.extension.AbstractExtension;

/**
 * Implementação do ConcreteExtensionA.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteExtensionA implements AbstractExtension {

  private final ConcreteSubject subject;

  public ConcreteExtensionA(final ConcreteSubject subject) {
    this.subject = subject;
  }

  @Override
  public String effect() {
    return String.format("*** %s ***%n", this.subject.getValue());
  }
}

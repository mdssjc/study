package com.github.mdssjc.dp.extension_objects.extension.concrete;

import com.github.mdssjc.dp.extension_objects.concrete.ConcreteSubject;
import com.github.mdssjc.dp.extension_objects.extension.AbstractExtension;

/**
 * Implementação do ConcreteExtensionB.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteExtensionB implements AbstractExtension {

  private final ConcreteSubject subject;

  public ConcreteExtensionB(final ConcreteSubject subject) {
    this.subject = subject;
  }

  @Override
  public String effect() {
    return String.format("[[[ %s ]]]%n", this.subject.getValue());
  }
}

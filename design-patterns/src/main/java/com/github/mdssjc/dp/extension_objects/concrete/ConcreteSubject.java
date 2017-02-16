package com.github.mdssjc.dp.extension_objects.concrete;

import com.github.mdssjc.dp.extension_objects.Subject;
import com.github.mdssjc.dp.extension_objects.extension.concrete.ConcreteExtensionA;
import com.github.mdssjc.dp.extension_objects.extension.Extension;

/**
 * Implementação do ConcreteSubject.
 *
 * @author Marcelo dos Santos
 *
 */
public class ConcreteSubject implements Subject {

  private Extension extension;
  private final String value;

  public ConcreteSubject(final String value) {
    this.value = value;
    addExtension(new ConcreteExtensionA(this));
  }

  @Override
  public Extension getExtension() {
    return this.extension;
  }

  @Override
  public void addExtension(final Extension extension) {
    this.extension = extension;
  }

  public String getValue() {
    return this.value;
  }
}

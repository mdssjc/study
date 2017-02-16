package com.github.mdssjc.dp.extension_objects.base;

import com.github.mdssjc.dp.extension_objects.concrete.ConcreteSubject;
import com.github.mdssjc.dp.extension_objects.extension.AbstractExtension;
import com.github.mdssjc.dp.extension_objects.extension.concrete.ConcreteExtensionB;

/**
 * Test drive do padrão de projeto Extension Objects.
 * <p>
 * Design Pattern
 *
 * @author Marcelo dos Santos
 *
 */
public class Main {

  public static void main(final String[] args) {
    final ConcreteSubject subject = new ConcreteSubject("Extension Objects");
    AbstractExtension extension = (AbstractExtension) subject.getExtension();

    String result = extension.effect();
    System.out.println(result);

    subject.addExtension(new ConcreteExtensionB(subject));
    extension = (AbstractExtension) subject.getExtension();

    result = extension.effect();
    System.out.println(result);
  }
}

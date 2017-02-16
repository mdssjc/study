package com.github.mdssjc.dp.extension_objects;

import com.github.mdssjc.dp.extension_objects.extension.Extension;

/**
 * Implementação do Subject.
 *
 * @author Marcelo dos Santos
 *
 */
public interface Subject {

  Extension getExtension();

  void addExtension(Extension extension);
}

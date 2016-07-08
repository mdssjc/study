package com.javacodegeeks.advanced.design;

import java.io.IOException;
import java.nio.CharBuffer;

public interface DefaultMethods extends Runnable, AutoCloseable {

  @Override
  default void run() {
    // Some implementation here
  }

  @Override
  default void close() throws Exception {
    // Some implementation here
  }
}

// Class C inherits the implementation of run() and close() methods from the
// DefaultMethods interface.
class C2 implements DefaultMethods, Readable {

  @Override
  public int read(CharBuffer cb) throws IOException {
    // Some implementation here
    return 0;
  }
}

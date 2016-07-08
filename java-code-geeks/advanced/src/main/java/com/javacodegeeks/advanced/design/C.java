package com.javacodegeeks.advanced.design;

import java.io.IOException;
import java.nio.CharBuffer;

// Class C wants to inherit the implementation of run() method from class A
// and the implementation of close() method from class B.
public class C extends B implements Readable {

  @Override
  public int read(CharBuffer cb) throws IOException {
    // Some implementation here
    return 0;
  }
}

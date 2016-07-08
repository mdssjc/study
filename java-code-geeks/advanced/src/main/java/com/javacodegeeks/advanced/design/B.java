package com.javacodegeeks.advanced.design;

// Class B wants to inherit the implementation of run() method from class A.
public class B extends A implements AutoCloseable {

  @Override
  public void close() throws Exception {
    // Some implementation here
  }
}

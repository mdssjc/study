package com.javacodegeeks.advanced.generics;

public class ClassImplementingGenericInterface
    implements GenericInterfaceOneType<String> {

  @Override
  public void performAction(final String action) {
    // Implementation here
  }
}

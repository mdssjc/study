package com.javacodegeeks.advanced.generics;

public class GenericClassImplementingGenericInterface<T>
    implements GenericInterfaceOneType<T> {

  @Override
  public void performAction(final T action) {
    // Implementation here
  }
}

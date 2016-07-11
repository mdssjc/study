package com.javacodegeeks.advanced.generics;

import java.util.Collection;

public class GenericMethods<T> {

  public GenericMethods(final T initialAction) {
    // Implementation here
  }

  public <J> GenericMethods(final T initialAction, final J nextAction) {
    // Implementation here
  }

  public static <T, R> R performActionOn(final Collection<T> action) {
    final R result = null;
    // Implementation here
    return result;
  }

  public <R> R performAction(final T action) {
    final R result = null;
    // Implementation here
    return result;
  }

  public <U, R> R performAnotherAction(final U action) {
    final R result = null;
    // Implementation here
    return result;
  }
}

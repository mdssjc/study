package com.github.mdssjc.algorithms.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

public class Executor {

  public static <T> String[][] toXSS(final T... xs) {
    return Arrays.stream(xs)
                 .map(String::valueOf)
                 .map(x -> new String[] { x })
                 .toArray(String[][]::new);
  }

  public static <T> String[] toXS(final T... xs) {
    return Arrays.stream(xs)
                 .map(String::valueOf)
                 .toArray(String[]::new);
  }

  public static <T> void execute(final Consumer<T> method, final T... xs) {
    if (xs.length == 0) {
      method.accept(null);
    }

    for (final T input : xs) {
      method.accept(input);
    }
  }

  public static void execute(final Class<?> clazz, final String[]... inputs) {
    try {
      final Method method = clazz.getMethod("main", String[].class);

      if (inputs.length == 0) {
        method.invoke(null, (Object) null);
      } else {
        for (final String[] input : inputs) {
          method.invoke(null, (Object) input);
        }
      }
    } catch (IllegalAccessException | IllegalArgumentException
        | InvocationTargetException | NoSuchMethodException
        | SecurityException exception) {
      System.err.println(exception.getMessage());
    }
  }
}

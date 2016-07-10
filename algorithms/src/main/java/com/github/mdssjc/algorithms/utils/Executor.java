package com.github.mdssjc.algorithms.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Executor {

  public static <T> String[] convert(final T... xs) {
    return Arrays.stream(xs)
                 .map(String::valueOf)
                 .toArray(String[]::new);
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

package com.github.mdssjc.algorithms.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;

/**
 * Executor Class.
 * 
 * @author Marcelo dos Santos
 *
 */
public class Executor {

  public static void execute(final Class<?> clazz) {
    try {
      final Method method = clazz.getMethod("main", String[].class);
      final Annotation[] annotations = clazz
        .getAnnotationsByType(TestDrive.class);

      // if (annotations.length == 0) {
      // StdOut.printf("java %s%n", clazz.getSimpleName());
      // method.invoke(null, (Object) null);
      // } else {
      for (final Annotation annotation : annotations) {
        final TestDrive td = (TestDrive) annotation;
        StdOut.printf("java %s %s%n", clazz.getSimpleName(),
            Arrays.deepToString(td.value()));

        // if (td.isFile()) {
        // System.out.println(clazz.getPackage().getName());
        // } else {
        // }
        method.invoke(null, (Object) td.value());
      }
      // }
    } catch (IllegalArgumentException | NoSuchMethodException
        | SecurityException | IllegalAccessException
        | InvocationTargetException exception) {
      StdOut.println(exception.getMessage());
    }
  }
}

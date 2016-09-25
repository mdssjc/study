package com.github.mdssjc.algorithms.utils;

import java.io.ByteArrayInputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Collectors;

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

//      Queue<String> queue = new LinkedList<>();
//      StubbedInputStream in = new StubbedInputStream(queue);
//      for (final Annotation annotation : annotations) {
//        final TestDrive td = (TestDrive) annotation;
//        queue.add(Arrays.stream(td.input())
//          .collect(Collectors.joining(" ")));
//      }
//
//      System.setIn(in);

      for (final Annotation annotation : annotations) {
        final TestDrive td = (TestDrive) annotation;
        StdOut.printf("java %s %s%n", clazz.getSimpleName(),
            Arrays.deepToString(td.value()));

        final String[] value = td.value();
        if (td.valueFile()) {
          value[0] = "src/main/resources/" + value[0];
        }

        if (td.input().length > 0) {
          System.setIn(new ByteArrayInputStream(
              Arrays.stream(td.input())
                .collect(Collectors.joining(" "))
                .getBytes()));
        }

        method.invoke(null, (Object) value);
      }
      // }
    } catch (IllegalArgumentException | NoSuchMethodException
        | SecurityException | IllegalAccessException
        | InvocationTargetException exception) {
      StdOut.println(exception.getMessage());
    }
  }

  public static void execute(final Class<?> clazz, final String label) {
    StdOut.println(label);
    execute(clazz);
    StdOut.println();
  }

  public static void execute(final Class<?> clazz, final String[] args) {
    if (args.length == 0) {
      execute(clazz);
      System.exit(0);
    }
  }
}

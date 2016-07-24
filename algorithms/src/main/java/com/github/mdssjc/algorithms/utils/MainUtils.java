package com.github.mdssjc.algorithms.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Utilitário para entrada de dados no main e classes de teste.
 * 
 * @author Marcelo dos Santos
 *
 */
public class MainUtils {

  /**
   * Converte para String[][].
   * 
   * @param xs
   *          Conjunto de valores
   * @return String[][]
   */
  public static <T> String[][] toXSS(final T... xs) {
    return Arrays.stream(xs)
                 .map(String::valueOf)
                 .map(x -> new String[] { x })
                 .toArray(String[][]::new);
  }

  /**
   * Converte para String[]
   * 
   * @param xs
   *          Conjunto de valores
   * @return String[]
   */
  public static <T> String[] toXS(final T... xs) {
    return Arrays.stream(xs)
                 .map(String::valueOf)
                 .toArray(String[]::new);
  }

  /**
   * Execução do ponto de entrada da classe.
   * 
   * @param method
   *          Método a ser executado
   * @param xs
   *          Valores para o args
   */
  public static <T> void execute(final Consumer<T> method, final T... xs) {
    if (xs.length == 0) {
      method.accept(null);
    }

    for (final T input : xs) {
      method.accept(input);
    }
  }

  /**
   * Execução do main.
   * 
   * @param clazz
   *          Classe selecionada
   * @param inputs
   *          Valores para o args
   */
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

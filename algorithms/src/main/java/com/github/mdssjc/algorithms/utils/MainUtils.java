package com.github.mdssjc.algorithms.utils;

import java.util.Arrays;

/**
 * Utilitário para conversão de dados para o main.
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
}

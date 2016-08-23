package com.github.mdssjc.cdc.ra.ch02;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UsoConstrutor {

  public UsoConstrutor(final String s) {
    System.out.println("Construtor invocado com: " + s);
  }

  public static void main(final String[] args) throws NoSuchMethodException,
      SecurityException {
    final Class<UsoConstrutor> c = UsoConstrutor.class;
    final Constructor<UsoConstrutor> constr = c.getConstructor(String.class);
    try {
      final UsoConstrutor obj = constr.newInstance("teste");
    } catch (final InstantiationException e) {
      e.printStackTrace();
    } catch (final IllegalAccessException e) {
      e.printStackTrace();
    } catch (final IllegalArgumentException e) {
      e.printStackTrace();
    } catch (final InvocationTargetException e) {
      System.out
        .println("Exceção lançada pelo construtor: " + e.getTargetException());
    }
  }
}
